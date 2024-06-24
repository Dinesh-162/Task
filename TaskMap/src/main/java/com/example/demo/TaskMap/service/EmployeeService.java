package com.example.demo.TaskMap.service;



import com.example.demo.TaskMap.entity.Employee;
import com.example.demo.TaskMap.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private static EmployeeRepository employeeRepository;

    public List<Employee> searchByEmployeeName(String employeeName) {
        return employeeRepository.findByEmployeeNameContaining(employeeName);
    }

    public List<Employee> searchByEmployeeSkill(String employeeSkill) {
        return employeeRepository.findByEmployeeSkillsEmployeeSkillContaining(employeeSkill);
    }

    public List<Employee> searchByEmployeeRoll(String employeeRoll) {
        return employeeRepository.findByEmployeeRollEmployeeRollContaining(employeeRoll);
    }
}
