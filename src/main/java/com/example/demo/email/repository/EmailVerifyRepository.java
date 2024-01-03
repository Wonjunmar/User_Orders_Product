package com.example.demo.email.repository;

import com.example.demo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailVerifyRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByEmail(String email);

}
