package com.seyitkoc.entity.debt;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.seyitkoc.enums.DebtType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "debts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Debt {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DebtType type;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "debt", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonManagedReference
    private List<ApartmentDebts> apartmentDebts;

    @Column(name = "building_id", nullable = false)
    private Long buildingId;
}
