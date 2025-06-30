package com.seyitkoc.dto.debt;

import com.seyitkoc.dto.apartment.DtoApartmentDebts;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoDebt {
    private Long id;
    private String description;
    private Double amount;
    private String type;
    private String createdAt;
    private String updatedAt;
    private Long buildingId;
    private List<DtoApartmentDebts> apartmentDebts;
}
