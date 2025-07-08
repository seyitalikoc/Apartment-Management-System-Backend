package com.seyitkoc.dto.apartmentAccount;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoApartmentAccount {
    private Long id;
    private Double balance;
    private Long apartmentId;
    private Long apartmentNumber;
}
