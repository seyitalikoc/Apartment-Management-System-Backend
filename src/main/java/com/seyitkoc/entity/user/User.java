package com.seyitkoc.entity.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.seyitkoc.entity.auth.Auth;
import com.seyitkoc.entity.building.Building;
import com.seyitkoc.entity.apartment.Apartment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "auth_id", referencedColumnName = "id")
    @ToString.Exclude
    @JsonManagedReference
    private Auth auth;

    @OneToMany(mappedBy = "manager")
    @ToString.Exclude
    @JsonManagedReference
    private List<Building> managedBuildings = new ArrayList<>();


    @OneToMany(mappedBy = "owner")
    @ToString.Exclude
    @JsonManagedReference
    private List<Apartment> ownedApartments = new ArrayList<>();

    @OneToOne(mappedBy = "tenant")
    @ToString.Exclude
    @JsonManagedReference
    private Apartment rentedApartment;
}
