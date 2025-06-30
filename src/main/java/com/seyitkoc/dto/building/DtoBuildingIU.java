package com.seyitkoc.dto.building;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoBuildingIU {
    private String name;
    private String address;
    private Long floorCount;
    private Long apartmentCount;
}
