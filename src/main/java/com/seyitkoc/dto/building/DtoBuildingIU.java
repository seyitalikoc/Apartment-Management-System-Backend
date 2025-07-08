package com.seyitkoc.dto.building;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoBuildingIU {
    @Size(min = 1, max = 50)
    private String name;

    @Size(min = 1, max = 150)
    private String address;

    @NotNull
    private Long floorCount;

    @NotNull
    private Long apartmentCount;
}
