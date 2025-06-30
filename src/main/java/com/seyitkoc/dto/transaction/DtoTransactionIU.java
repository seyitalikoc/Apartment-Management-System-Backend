package com.seyitkoc.dto.transaction;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoTransactionIU {
    private String description;
    private Double amount;
    private String type; // INCOME & EXPENSE
    private String subType;
    private Long buildingAccountId;
}
