package com.seyitkoc.mapper;

import com.seyitkoc.dto.user.DtoUser;
import com.seyitkoc.entity.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final BuildingMapper buildingMapper;

    public UserMapper(BuildingMapper buildingMapper) {
        this.buildingMapper = buildingMapper;
    }

    public DtoUser toDtoUser(User user) {
        if (user == null) {
            return null;
        }

        DtoUser dtoUser = new DtoUser();
        dtoUser.setName(user.getName());
        dtoUser.setPhone(user.getPhone());
        dtoUser.setBuildings(user.getManagedBuildings().stream()
                .map(buildingMapper::toDtoBuilding)
                .toList());
        return dtoUser;
    }

}
