package com.example.finalprojectback.repository;

import com.example.finalprojectback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
