package com.example.demo_api1.Repository;

import com.example.demo_api1.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  TodoRepository extends JpaRepository<Task,Long> {
}
