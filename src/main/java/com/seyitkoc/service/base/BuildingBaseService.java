package com.seyitkoc.service.base;

import com.seyitkoc.entity.Building;
import com.seyitkoc.repository.BuildingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BuildingBaseService {
    private final BuildingRepository buildingRepository;

    public BuildingBaseService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public Page<Building> getBuildingsByUser(
            Long userId, int page, int pageSize, String sortBy, String sortDirection) {
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        return buildingRepository.findAllByManager_Id(userId, pageRequest);
    }
}
