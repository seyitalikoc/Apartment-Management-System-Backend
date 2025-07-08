package com.seyitkoc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "building_due")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Due {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_of_month")
    private String dayOfMonth;

    @Column(name = "due_amount")
    private Double dueAmount;

    @OneToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;
}
