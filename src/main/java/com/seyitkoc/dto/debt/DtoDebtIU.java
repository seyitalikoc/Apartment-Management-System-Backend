package com.seyitkoc.dto.debt;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoDebtIU {
    private String description;
    private Double amount;
    private String type;
    private Long buildingId;
    private Set<Long> apartmentIds;
}
