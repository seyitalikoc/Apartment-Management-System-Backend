package com.seyitkoc.dto.building.account;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtoBuildingAccount {
    private Long id;
    private String name;
    private String type;
    private Integer year;
    private Double balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActive;
    private Long buildingId;
}
