package com.seyitkoc.dto.due;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoDue {
    private Long id;
    private String dayOfMonth;
    private Double dueAmount;
    private Long buildingId;
}
