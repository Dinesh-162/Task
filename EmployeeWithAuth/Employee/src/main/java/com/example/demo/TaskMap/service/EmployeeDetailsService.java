package com.example.demo.TaskMap.service;

import com.example.demo.TaskMap.entity.EmployeeDetails;
import com.example.demo.TaskMap.repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsService {

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    public EmployeeDetails saveEmployeeDetails(EmployeeDetails employeeDetails) {
        return employeeDetailsRepository.save(employeeDetails);
    }
}
