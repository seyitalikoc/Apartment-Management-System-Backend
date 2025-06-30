package com.seyitkoc.dto.transaction;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoTransaction {
    private Long id;
    private String description;
    private Double amount;
    private String type; // INCOME & EXPENSE
    private String subType;
    private String transactionDate;
    private String updatedAt;
    private Long buildingAccountId;
    private String buildingAccountName;
}
