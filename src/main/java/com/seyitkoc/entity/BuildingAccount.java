package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.seyitkoc.entity.transaction.Transaction;
import com.seyitkoc.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building_account")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BuildingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "balance", nullable = false)
    private Double balance = 0.0;

    @Column(name = "balance_updated_at", nullable = false)
    private LocalDateTime balanceUpdatedAt; // to track last balance update time

    @Formula(
            "(SELECT COALESCE(SUM(" +
                    " CASE WHEN t.type = 'INCOME' THEN t.amount " +
                    "      WHEN t.type = 'EXPENSE' THEN -t.amount " +
                    "      ELSE 0 END), 0) " +
                    " FROM transactions t WHERE t.building_account = id)"  // building_account_id yerine building_account
    )
    @Basic(fetch = FetchType.LAZY)
    private Double balanceCalculated;

    @Column(name = "account_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt; // to track last info update time (not balance update)

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id", nullable = false)
    @JsonBackReference
    private Building building;

    @OneToMany(mappedBy = "buildingAccount", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Transaction> transactions = new ArrayList<>();
}
