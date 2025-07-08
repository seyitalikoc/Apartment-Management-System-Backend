package com.seyitkoc.dto.debt;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoDebtIU {
    @Size(min = 1, max = 150)
    private String description;

    @NotNull
    @PositiveOrZero
    private Double amount;

    @NotNull
    private String type;

    @NotNull
    private Long buildingId;

    @NotEmpty
    private Set<Long> apartmentIds;
}
