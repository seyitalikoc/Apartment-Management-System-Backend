package com.seyitkoc.dto.transaction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoTransactionIU {
    @Size(min = 1, max = 250)
    private String description;

    @NotNull
    @Positive
    private Double amount;

    @NotNull
    private String type; // INCOME & EXPENSE

    @NotNull
    private String subType;

    @NotNull
    private Long buildingAccountId;
}
