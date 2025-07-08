package com.seyitkoc.service;

import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.entity.User;
import com.seyitkoc.dto.user.DtoUser;
import com.seyitkoc.dto.user.DtoUserCreate;
import com.seyitkoc.dto.user.DtoUserUpdate;
import org.springframework.data.domain.Page;

public interface IUserService {
    String createNewUser(DtoUserCreate dtoUserCreate);

    DtoUser getUserByTokenAndId(String token, Long id);

    String updateUser(String token, DtoUserUpdate dtoUserUpdate);

    String deleteUser(String token);

    User getUserByEmail(String email);

    User getUserById(Long id);

    void checkUserIsMemberOfBuilding(String email, Long buildingId);

    void checkUserIsManagerOfBuilding(User user, Long buildingId);
    void checkUserIsManagerOfBuilding(String email, Long buildingId);

    void checkUserIsOwnerOrTenantOfApartment(User user, Long apartmentId);
    void checkUserIsOwnerOrTenantOfApartment(String email, Long apartmentId);

    void checkUserIsOwnerOfApartment(String email, Long apartmentId);

    Page<DtoBuilding> getBuildingsByUser(String token, int page, int size, String sortBy, String sortDirection);

    Page<DtoApartment> getOwnerApartmentsByUser(String token, int page, int size, String sortBy, String sortDirection);

    DtoApartment getRentedApartmentByUser(String token);
}
