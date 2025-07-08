package com.seyitkoc.repository;

import com.seyitkoc.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {"ownedApartments", "rentedApartment"})
    User getUserWithApartmentsById(Long id);

    @EntityGraph("managedBuildings")
    User getUserWithManagedBuildingsById(Long id);

    Optional<User> getUserById(Long id);
}
