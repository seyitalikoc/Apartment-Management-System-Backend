package com.seyitkoc.service.impl;

import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.dto.building.DtoBuildingIU;
import com.seyitkoc.entity.building.Building;
import com.seyitkoc.entity.user.User;
import com.seyitkoc.mapper.BuildingMapper;
import com.seyitkoc.repository.BuildingRepository;
import com.seyitkoc.security.JwtTokenService;
import com.seyitkoc.service.IApartmentService;
import com.seyitkoc.service.IBuildingAccountService;
import com.seyitkoc.service.IBuildingService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl implements IBuildingService {
    private final BuildingRepository buildingRepository;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final IApartmentService apartmentService;
    private final IBuildingAccountService buildingAccountService;
    private final BuildingMapper buildingMapper;

    public BuildingServiceImpl(BuildingRepository buildingRepository, IUserService userService, JwtTokenService jwtTokenService, IApartmentService apartmentService, IBuildingAccountService buildingAccountService, BuildingMapper buildingMapper) {
        this.buildingRepository = buildingRepository;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
        this.apartmentService = apartmentService;
        this.buildingAccountService = buildingAccountService;
        this.buildingMapper = buildingMapper;
    }

    @Override
    public Building getBuildingById(Long buildingId) {
        return buildingRepository.findById(buildingId).orElseThrow(() -> new IllegalArgumentException("Building not found"));
    }

    @Override
    public DtoBuilding getBuildingById(String token, Long buildingId) {
        User user = userService.getUserByEmail(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")));
        if (user == null){
            throw new IllegalArgumentException("User not found");
        }
        if(user.getManagedBuildings().stream().anyMatch(building -> building.getId().equals(buildingId)) ||
                user.getOwnedApartments().stream().anyMatch(apartment -> apartment.getBuilding().getId().equals(buildingId)) ||
                user.getRentedApartment().getBuilding().getId().equals(buildingId)
        ) {
            Building building = buildingRepository.findById(buildingId)
                    .orElseThrow(() -> new IllegalArgumentException("Building not found"));
            return buildingMapper.toDtoBuilding(building);
        }else {
            throw new IllegalArgumentException("Building not found or user does not have access to building.");
        }

    }

    @Transactional
    @Override
    public String saveBuilding(DtoBuildingIU dtoBuildingIU) {
        Building building = buildingMapper.toBuilding(dtoBuildingIU);
        building = buildingRepository.save(building);
        if (building.getId() == null) {
            throw new IllegalArgumentException("Building could not be saved");
        }
        apartmentService.createApartmentsForBuilding(building, dtoBuildingIU.getApartmentCount());
        buildingAccountService.createAccountsWhenBuildingCreate(building);
        return "Building saved successfully.";
    }

    @Override
    public DtoBuilding changeManager(Long buildingId, Long managerId) {
        Building building = buildingRepository.findById(buildingId)
            .orElseThrow(() -> new IllegalArgumentException("Building not found"));
        if (building.getManager() != null && building.getManager().getId().equals(managerId)) {
            throw new IllegalArgumentException("This user is already the manager of the building.");
        }
        building.setManager(userService.getUserById(managerId));
        building = buildingRepository.save(building);
        return buildingMapper.toDtoBuilding(building);
    }

    @Transactional
    @Override
    public String updateBuilding(DtoBuildingIU dtoBuildingIU, Long id, String token) {
        User user = userService.getUserByEmail(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")));
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        if(user.getManagedBuildings().stream().noneMatch(building -> building.getId().equals(id))){
            throw new IllegalArgumentException("Building not found or user does not have access to building.");
        }
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Building not found"));
        if(!dtoBuildingIU.getName().isEmpty()){
            building.setName(dtoBuildingIU.getName());
        }
        if(!dtoBuildingIU.getAddress().isEmpty()){
            building.setAddress(dtoBuildingIU.getAddress());
        }
        if(dtoBuildingIU.getFloorCount() != null && !dtoBuildingIU.getFloorCount().equals(building.getFloorCount())) {
            building.setFloorCount(dtoBuildingIU.getFloorCount());
        }
        if(dtoBuildingIU.getApartmentCount() != null && !dtoBuildingIU.getApartmentCount().equals(building.getApartmentCount())) {
            apartmentService.createApartmentsForBuilding(building, dtoBuildingIU.getApartmentCount());
            building.setApartmentCount(dtoBuildingIU.getApartmentCount());
        }
        building = buildingRepository.save(building);
        if (building.getId() == null) {
            throw new IllegalArgumentException("Building could not be updated");
        }
        return "Building updated successfully.";
    }

    @Override
    public String updateBuildingStatus(Long id, String status) {
        Building building = buildingRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Building not found"));
        if(status.equals("active") && !building.isActive()){
            building.setActive(true);
        } else if(status.equals("passive") && building.isActive()){
            building.setActive(false);
        } else {
            throw new IllegalArgumentException("Invalid status change request");
        }
        buildingRepository.save(building);
        return "Building status updated successfully";
    }

    @Transactional
    @Override
    public String deleteBuilding(Long id) {
        Building building = buildingRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Building not found"));
        if (building.isActive()){
            throw new IllegalArgumentException("Building is active");
        }
        buildingRepository.delete(building);
        return "Building deleted successfully.";
    }
}
