package com.seyitkoc.service;

import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.dto.building.DtoBuildingIU;
import com.seyitkoc.entity.building.Building;

public interface IBuildingService {
    Building getBuildingById(Long buildingId);

    DtoBuilding getBuildingById(String token, Long buildingId);

    String saveBuilding(DtoBuildingIU dtoBuildingIU);

    DtoBuilding changeManager(Long buildingId, Long managerId);

    String updateBuilding(DtoBuildingIU dtoBuildingIU, Long id, String token);

    String updateBuildingStatus(Long id, String status);

    String deleteBuilding(Long id);
}
