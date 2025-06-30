package com.seyitkoc.dto.building.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoBuildingAccountIU {
    private String name;
    private String type;
    private Long buildingId;
    private Double balance;
}
