package com.seyitkoc.dto.user;

import com.seyitkoc.dto.building.DtoBuilding;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoUser {
    private String name;
    private String phone;

    private List<DtoBuilding> buildings;
}
