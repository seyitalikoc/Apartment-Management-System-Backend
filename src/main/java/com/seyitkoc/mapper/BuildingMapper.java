package com.seyitkoc.mapper;

import com.seyitkoc.entity.Building;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.dto.building.DtoBuildingIU;
import com.seyitkoc.entity.Apartment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BuildingMapper {

    public DtoBuilding toDtoBuilding(Building building) {
        DtoBuilding dtoBuilding = new DtoBuilding();
        dtoBuilding.setId(building.getId());
        dtoBuilding.setName(building.getName());
        dtoBuilding.setAddress(building.getAddress());
        dtoBuilding.setApartmentCount(building.getApartmentCount());
        dtoBuilding.setFloorCount(building.getFloorCount());
        dtoBuilding.setActive(building.isActive());
        dtoBuilding.setManagerId(building.getManager() != null ? building.getManager().getId() : null);
        dtoBuilding.setApartmentIds(building.getApartments().stream()
                .map(Apartment::getId)
                .toList());
        return dtoBuilding;
    }

    public Building toBuilding(DtoBuildingIU dtoBuildingIU) {
        Building building = new Building();
        building.setName(dtoBuildingIU.getName());
        building.setAddress(dtoBuildingIU.getAddress());
        building.setApartmentCount(dtoBuildingIU.getApartmentCount());
        building.setFloorCount(dtoBuildingIU.getFloorCount());
        building.setActive(false);
        building.setApartments(new ArrayList<>());
        return building;
    }
}
