package com.example.demo.TaskMap.repository;

import com.example.demo.TaskMap.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmployeeName(String employeeName);

    @Query(value = "SELECT * FROM Employee e WHERE e.employee_id = :id", nativeQuery = true)
    Optional<Employee> findByIdNative(@Param("id") Long id);

    List<Employee> findByEmployeeDetails_EmployeeSkill(String employeeSkill);

    List<Employee> findByEmployeeDetails_EmployeeRoll(String employeeRoll);
}
