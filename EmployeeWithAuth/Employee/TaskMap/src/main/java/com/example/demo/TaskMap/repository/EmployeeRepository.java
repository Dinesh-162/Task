package com.example.demo.TaskMap.repository;

import com.example.demo.TaskMap.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmployeeName(String employeeName);

    List<Employee> findByEmployeeDetails_EmployeeSkill(String employeeSkill);

    List<Employee> findByEmployeeDetails_EmployeeRoll(String employeeRoll);
}
