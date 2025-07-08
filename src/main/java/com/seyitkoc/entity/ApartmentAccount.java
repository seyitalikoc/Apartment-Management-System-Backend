package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Formula;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "apartment_account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance", nullable = false)
    private Double balance = 0.0;

    @Column(name = "balance_updated_at", nullable = false)
    private LocalDateTime balanceUpdatedAt = LocalDateTime.now();

    @Formula("(SELECT COALESCE(SUM(d.amount), 0) FROM debts d INNER JOIN apartment_debts ad ON ad.debt_id = d.id WHERE ad.apartment_account_id = id AND ad.is_paid = false AND ad.is_confirmed = false)")
    @Basic(fetch = FetchType.LAZY)
    private Double balanceCalculated;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id", nullable = false)
    @ToString.Exclude
    @JsonBackReference
    private Apartment apartment;

    @OneToMany(mappedBy = "apartmentAccount", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    @ToString.Exclude
    private List<ApartmentDebts> apartmentDebts = new ArrayList<>();
}
