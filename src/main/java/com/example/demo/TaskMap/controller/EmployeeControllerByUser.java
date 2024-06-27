package com.example.demo.TaskMap.controller;

import com.example.demo.TaskMap.entity.Employee;
import com.example.demo.TaskMap.service.EmployeeService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeControllerByUser {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/user/getEmployee/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/searchByName")
    @PreAuthorize("hasRole('USER')")
    public List<Employee> searchByEmployeeName(@RequestParam String name) {
        return employeeService.searchByEmployeeName(name);
    }

    @GetMapping("/user/searchBySkill")
    @PreAuthorize("hasRole('USER')")
    public List<Employee> searchByEmployeeSkill(@RequestParam String skill) {
        return employeeService.searchByEmployeeSkill(skill);
    }

    @GetMapping("/user/searchByRoll")
    @PreAuthorize("hasRole('USER')")
    public List<Employee> searchByEmployeeRoll(@RequestParam String roll) {
        return employeeService.searchByEmployeeRoll(roll);
    }

}

