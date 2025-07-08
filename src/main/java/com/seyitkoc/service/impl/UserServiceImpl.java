package com.seyitkoc.service.impl;

import com.seyitkoc.service.IUserService;
import com.seyitkoc.service.base.ApartmentBaseService;
import com.seyitkoc.mapper.ApartmentMapper;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.service.base.BuildingBaseService;
import com.seyitkoc.mapper.BuildingMapper;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.entity.User;
import com.seyitkoc.mapper.UserMapper;
import com.seyitkoc.repository.UserRepository;
import com.seyitkoc.dto.user.DtoUser;
import com.seyitkoc.dto.user.DtoUserCreate;
import com.seyitkoc.dto.user.DtoUserUpdate;
import com.seyitkoc.entity.Auth;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IAuthService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class UserServiceImpl implements IUserService {
    private final IAuthService authService;
    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;
    private final UserMapper userMapper;
    private final ApartmentBaseService apartmentBaseService;
    private final ApartmentMapper apartmentMapper;
    private final BuildingBaseService buildingBaseService;
    private final BuildingMapper buildingMapper;

    public UserServiceImpl(IAuthService authService, UserRepository userRepository, JwtTokenService jwtTokenService, UserMapper userMapper, ApartmentBaseService apartmentBaseService, ApartmentMapper apartmentMapper, BuildingBaseService buildingBaseService, BuildingMapper buildingMapper) {
        this.authService = authService;
        this.userRepository = userRepository;
        this.jwtTokenService = jwtTokenService;
        this.userMapper = userMapper;
        this.apartmentBaseService = apartmentBaseService;
        this.apartmentMapper = apartmentMapper;
        this.buildingBaseService = buildingBaseService;
        this.buildingMapper = buildingMapper;
    }

    @Transactional
    @Override
    public String createNewUser(DtoUserCreate dtoUserCreate) {
        User user = User.builder()
                .name(dtoUserCreate.getName())
                .phone(dtoUserCreate.getPhone())
                .build();

        Auth auth = authService.createNewAuth(dtoUserCreate.getEmail(), dtoUserCreate.getPassword(), userRepository.save(user));
        if (auth == null) {
            throw new ApplicationException(new ErrorMessage(MessageType.AUTH_CREATION_FAILED, "Failed to create user authentication"));
        }
        return "User created successfully.";
    }

    @Override
    public DtoUser getUserByTokenAndId(String token, Long id) {
        Auth auth = authService.getAuthByToken(token);
        // if auth is null, it means the token is invalid or expired
        if (auth == null) {
            throw new ApplicationException(new ErrorMessage(MessageType.INVALID_CREDENTIALS, "Invalid credentials"));
        }
        // if id is null, return the user associated with the auth
        if (id != null && !auth.getUser().getId().equals(id)) {
            return userMapper.toDtoUser(userRepository.getUserById(id).orElseThrow(() ->
                    new ApplicationException(new ErrorMessage(MessageType.USER_NOT_FOUND, "User not found with id: " + id))));
        }
        return userMapper.toDtoUser(auth.getUser());
    }

    @Override
    @Transactional
    public String updateUser(String token, DtoUserUpdate dtoUserUpdate) {
        User user = getUserByEmail(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")));
        if (!Objects.equals(user.getId(), dtoUserUpdate.getId())) {
            throw new ApplicationException(new ErrorMessage(MessageType.INVALID_CREDENTIALS, "Invalid credentials"));
        }
        if (dtoUserUpdate.getName() != null) {
            user.setName(dtoUserUpdate.getName());
        }
        if (dtoUserUpdate.getPhone() != null) {
            user.setPhone(dtoUserUpdate.getPhone());
        }
        userRepository.save(user);
        return "User records' updated successfully.";
    }

    @Override
    @Transactional
    public String deleteUser(String token) {
        User user = getUserByEmail(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")));
        if (user == null) {
            throw new ApplicationException(new ErrorMessage(MessageType.USER_NOT_FOUND, "User not found"));
        }
        userRepository.delete(user);
        if (!jwtTokenService.isTokenBlacklisted(token)) {
            jwtTokenService.blacklistToken(token);
        }
        return "User records' deleted successfully.";
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findAll().stream()
                .filter(user -> user.getAuth() != null && user.getAuth().getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.USER_NOT_FOUND, "User not found with email: " + email)));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id).orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.USER_NOT_FOUND, "User not found with id: " + id)));
    }

    @Override
    public void checkUserIsMemberOfBuilding(String email, Long buildingId) {
        if (isNotUserMemberOfBuildingOperation(getUserByEmail(email), buildingId))
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a member of the building with id: " + buildingId));
    }

    private boolean isNotUserMemberOfBuildingOperation(User user, Long buildingId) {
        if (user == null || buildingId == null) {
            return true;
        }
        boolean isManagedBuilding = isNotManagerOfBuildingOperation(user, buildingId);
        boolean isOwnedOrTenantApartment = isNotOwnerOrTenantOfApartmentOperation(user, buildingId);
        return isManagedBuilding && isOwnedOrTenantApartment;
    }

    @Override
    public void checkUserIsManagerOfBuilding(User user, Long buildingId) {
        if (isNotManagerOfBuildingOperation(user, buildingId))
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a manager of the building with id: " + buildingId));
    }

    @Override
    public void checkUserIsManagerOfBuilding(String email, Long buildingId) {
        if (isNotManagerOfBuildingOperation(getUserByEmail(email), buildingId))
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a manager of the building with id: " + buildingId));
    }

    private boolean isNotManagerOfBuildingOperation(User user, Long buildingId) {
        if (user == null || buildingId == null || user.getManagedBuildings() == null) {
            return true;
        }
        User temp = userRepository.getUserWithManagedBuildingsById(user.getId());
        if (temp != null && temp.getManagedBuildings().stream().anyMatch(building -> buildingId.equals(building.getId())))
            return false;

        return true;
    }

    @Override
    public void checkUserIsOwnerOrTenantOfApartment(User user, Long apartmentId) {
        if (isNotOwnerOrTenantOfApartmentOperation(user, apartmentId))
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not the owner or tenant of the apartment with id: " + apartmentId));
    }

    @Override
    public void checkUserIsOwnerOrTenantOfApartment(String email, Long apartmentId) {
        if (isNotOwnerOrTenantOfApartmentOperation(getUserByEmail(email), apartmentId))
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not the owner or tenant of the apartment with id: " + apartmentId));
    }

    private boolean isNotOwnerOrTenantOfApartmentOperation(User user, Long apartmentId) {
        if (user == null || apartmentId == null) {
            return true;
        }
        User temp = userRepository.getUserWithApartmentsById(user.getId());

        if (user.getOwnedApartments() != null && user.getOwnedApartments().stream().anyMatch(apartment ->
                apartment != null && apartment.getBuilding() != null && apartment.getId().equals(apartmentId)))
            return false;

        else return temp.getRentedApartment() == null || !user.getRentedApartment().getId().equals(apartmentId);
    }

    @Override
    public void checkUserIsOwnerOfApartment(String email, Long apartmentId) {
        User user = getUserByEmail(email);
        if (user == null || user.getOwnedApartments() == null) {
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not the owner of the apartment with id: " + apartmentId));
        }
        if (user.getOwnedApartments().stream().noneMatch(apartment -> apartment != null && apartment.getId().equals(apartmentId)))
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not the owner of the apartment with id: " + apartmentId));
    }

    @Override
    public Page<DtoBuilding> getBuildingsByUser(String token, int page, int size, String sortBy, String sortDirection) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        User user = getUserByEmail(email);
        return buildingBaseService
                .getBuildingsByUser(user.getId(), page, size, sortBy, sortDirection)
                .map(buildingMapper::toDtoBuilding);
    }

    @Override
    public Page<DtoApartment> getOwnerApartmentsByUser(String token, int page, int size, String sortBy, String sortDirection) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        User user = getUserByEmail(email);

        return apartmentBaseService.getOwnerApartmentsByUserId(user.getId(), page, size, sortBy, sortDirection)
                .map(apartmentMapper::toDtoApartment);
    }

    @Override
    public DtoApartment getRentedApartmentByUser(String token) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        User user = getUserByEmail(email);

        return apartmentMapper.toDtoApartment(apartmentBaseService.getRentedApartmentByUserId(user.getId()));
    }
}
