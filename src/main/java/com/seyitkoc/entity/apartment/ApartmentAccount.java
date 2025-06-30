package com.seyitkoc.entity.apartment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.seyitkoc.entity.debt.ApartmentDebts;
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
@ToString
public class ApartmentAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance", nullable = false)
    private Double balance = 0.0;

    @Column(name = "balance_updated_at", nullable = false)
    private LocalDateTime balanceUpdatedAt = LocalDateTime.now();

    @Formula("(SELECT COALESCE(SUM(d.amount), 0) FROM apartment_debts d WHERE d.apartment_id = id AND d.is_paid = false)")
    @Basic(fetch = FetchType.LAZY)
    private Double balanceCalculated;

    @OneToOne
    @JoinColumn(name = "apartment_id", nullable = false)
    @ToString.Exclude
    @JsonBackReference
    private Apartment apartment;

    @OneToMany(mappedBy = "apartmentAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @ToString.Exclude
    private List<ApartmentDebts> apartmentDebts = new ArrayList<>();


}
