package com.example.SpringBootDemo.repository;

import com.example.SpringBootDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * имя пакета Repository -> repository
     */
    User findByEmail(String email);
}
