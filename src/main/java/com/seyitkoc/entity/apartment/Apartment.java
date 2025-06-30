package com.seyitkoc.entity.apartment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.seyitkoc.entity.announcement.ApartmentAnnouncement;
import com.seyitkoc.entity.building.Building;
import com.seyitkoc.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "apartments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Apartment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apartment_number", nullable = false)
    private Long apartmentNumber;

    @Column(name = "apartment_floor")
    private Long apartmentFloor;

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    @ToString.Exclude
    @JsonBackReference
    private Building building;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @ToString.Exclude
    @JsonBackReference
    private User owner;

    @OneToOne
    @JoinColumn(name = "tenant_id")
    @ToString.Exclude
    @JsonBackReference
    private User tenant;

    @OneToOne(mappedBy = "apartment", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @JsonManagedReference
    private ApartmentAccount account;

    @Column(name="created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name="updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @JsonManagedReference
    private List<ApartmentAnnouncement> announcements = new ArrayList<>();
}
