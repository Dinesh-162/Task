package com.example.demo.TaskMap.repository;

import com.example.demo.TaskMap.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {
}
