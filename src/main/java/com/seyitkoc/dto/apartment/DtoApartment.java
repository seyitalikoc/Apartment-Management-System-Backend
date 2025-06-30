package com.seyitkoc.dto.apartment;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoApartment {
    private Long id;
    private Long apartmentNumber;
    private Long apartmentFloor;
    private Long buildingId;
    private Long ownerId;
    private Long tenantId;
    private Long accountId;
    private String createdAt;
    private String updatedAt;
}
