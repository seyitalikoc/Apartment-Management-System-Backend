package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "apartment_debts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ApartmentDebts {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private ApartmentAccount apartmentAccount;

    @ManyToOne
    @JsonBackReference
    private Debt debt;

    @Column(name = "is_paid")
    private boolean isPaid = false;
    @Column(name = "paid_at")
    private LocalDateTime paidAt;

    @Column(name = "is_confirmed")
    private boolean isConfirmed = false;
    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;
}
