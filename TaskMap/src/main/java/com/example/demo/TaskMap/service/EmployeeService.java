package com.example.demo.TaskMap.service;

import com.example.demo.TaskMap.entity.Employee;
import com.example.demo.TaskMap.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> searchByEmployeeName(String employeeName) {
        return employeeRepository.findByEmployeeName(employeeName);
    }

    public List<Employee> searchByEmployeeSkill(String employeeSkill) {
        return employeeRepository.findByEmployeeDetails_EmployeeSkill(employeeSkill);
    }

    public List<Employee> searchByEmployeeRoll(String employeeRoll) {
        return employeeRepository.findByEmployeeDetails_EmployeeRoll(employeeRoll);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
}
