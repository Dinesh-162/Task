package com.example.demo.TaskMap.repository;

import com.example.demo.TaskMap.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmployeeNameContaining(String employeeName);
    List<Employee> findByEmployeeSkillsEmployeeSkillContaining(String employeeSkill);
    List<Employee> findByEmployeeRollEmployeeRollContaining(String employeeRoll);
}
