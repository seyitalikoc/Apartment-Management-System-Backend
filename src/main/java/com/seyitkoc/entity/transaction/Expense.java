package com.seyitkoc.entity.transaction;

import com.seyitkoc.enums.ExpenseType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Expense extends Transaction {
    @Enumerated(value = EnumType.STRING)
    private ExpenseType expenseType;
}
