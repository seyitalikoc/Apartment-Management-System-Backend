package com.seyitkoc.repository;

import com.seyitkoc.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserById(Long id);
}
