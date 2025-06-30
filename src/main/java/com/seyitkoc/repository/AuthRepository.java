package com.seyitkoc.repository;

import com.seyitkoc.entity.auth.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {

    Optional<Auth> findAuthByEmail(String email);
}
