package com.seyitkoc.dto.building;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoBuilding {
    private Long id;
    private String name;
    private String address;
    private Long apartmentCount;
    private Long floorCount;
    private boolean isActive;
    private Long managerId;
    private List<Long> apartmentIds;
}
