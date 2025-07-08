package com.seyitkoc.entity.transaction;

import com.seyitkoc.enums.IncomeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("INCOME")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class Income extends Transaction {

    @Enumerated(value = EnumType.STRING)
    private IncomeType incomeType;
}
