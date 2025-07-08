package com.seyitkoc.entity.transaction;

import com.seyitkoc.enums.ExpenseType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("EXPENSE")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class Expense extends Transaction {
    @Enumerated(value = EnumType.STRING)
    private ExpenseType expenseType;
}
