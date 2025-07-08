package com.seyitkoc.repository;

import com.seyitkoc.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {

    @Query("SELECT a FROM Auth a WHERE a.email = ?1")
    Optional<Auth> findAuthByEmail(String email);
}
