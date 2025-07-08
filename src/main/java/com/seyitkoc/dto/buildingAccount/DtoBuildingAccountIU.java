package com.seyitkoc.dto.buildingAccount;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoBuildingAccountIU {
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull
    private String type;

    @NotNull
    private Long buildingId;

    @NotNull
    @PositiveOrZero
    private Double balance;
}
