package com.seyitkoc.dto.apartment;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoApartmentDebts {
    private Long id;
    private Long apartmentId;
    private Long debtId;
    private boolean isPaid;
    private String paidAt;
    private boolean isConfirmed;
    private String confirmedAt;
}
