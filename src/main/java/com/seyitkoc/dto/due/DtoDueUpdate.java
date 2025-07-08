package com.seyitkoc.dto.due;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoDueUpdate {
    private String dayOfMonth;
    private Double amount;
}
