package com.example.demo.TaskMap.controller;
import com.example.demo.TaskMap.entity.Employee;
import com.example.demo.TaskMap.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/searchByEmployeeName")
    public List<Employee> searchByEmployeeName(@RequestParam String employeeName) {
        return employeeService.searchByEmployeeName(employeeName);
    }

    @GetMapping("/searchByEmployeeSkill")
    public List<Employee> searchByEmployeeSkill(@RequestParam String employeeSkill) {
        return employeeService.searchByEmployeeSkill(employeeSkill);
    }

    @GetMapping("/searchByEmployeeRoll")
    public List<Employee> searchByEmployeeRoll(@RequestParam String employeeRoll) {
        return employeeService.searchByEmployeeRoll(employeeRoll);
    }
}