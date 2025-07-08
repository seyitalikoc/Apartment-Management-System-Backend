package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "User.ownedApartments",
                attributeNodes = @NamedAttributeNode("ownedApartments")
        ),
        @NamedEntityGraph(
                name = "User.rentedApartment",
                attributeNodes = @NamedAttributeNode("rentedApartment")
        ),
        @NamedEntityGraph(
                name = "User.managedBuildings",
                attributeNodes = @NamedAttributeNode("managedBuildings")
        )
})
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Auth auth;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private List<Building> managedBuildings = new ArrayList<>();


    @OneToMany(mappedBy = "owner", fetch =  FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private List<Apartment> ownedApartments = new ArrayList<>();

    @OneToOne(mappedBy = "tenant", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private Apartment rentedApartment;
}
