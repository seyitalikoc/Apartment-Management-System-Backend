package com.seyitkoc.entity.transaction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.seyitkoc.entity.building.BuildingAccount;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public abstract class Transaction {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "building_id")
    private Long buildingId;

    @ManyToOne
    @JoinColumn(name = "building_account", nullable = false)
    @ToString.Exclude
    @JsonBackReference
    private BuildingAccount buildingAccount;
}
