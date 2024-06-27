package com.example.demo.TaskMap.controller;

import com.example.demo.TaskMap.entity.EmployeeDetails;
import com.example.demo.TaskMap.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeDetailsController {

    @Autowired
    private EmployeeDetailsService employeeDetailsService;

    @PostMapping("/saveDetails")
    public EmployeeDetails saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
        return employeeDetailsService.saveEmployeeDetails(employeeDetails);
    }
}
