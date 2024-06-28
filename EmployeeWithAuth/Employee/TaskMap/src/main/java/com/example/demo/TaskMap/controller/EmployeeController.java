package com.example.demo.TaskMap.controller;

import com.example.demo.TaskMap.entity.Employee;
import com.example.demo.TaskMap.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/searchByName")
    public List<Employee> searchByEmployeeName(@RequestParam String name) {
        return employeeService.searchByEmployeeName(name);
    }

    @GetMapping("/searchBySkill")
    public List<Employee> searchByEmployeeSkill(@RequestParam String skill) {
        return employeeService.searchByEmployeeSkill(skill);
    }

    @GetMapping("/searchByRoll")
    public List<Employee> searchByEmployeeRoll(@RequestParam String roll) {
        return employeeService.searchByEmployeeRoll(roll);
    }
}
