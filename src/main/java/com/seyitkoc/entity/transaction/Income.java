package com.seyitkoc.entity.transaction;

import com.seyitkoc.enums.IncomeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Income extends Transaction {
    @Enumerated(value = EnumType.STRING)
    private IncomeType incomeType;
}
