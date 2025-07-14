package com.example.finalprojectback.repository;

import com.example.finalprojectback.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task , Long> {

}
