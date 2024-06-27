package com.example.demo.TaskMap.service;

import com.example.demo.TaskMap.entity.Employee;
import com.example.demo.TaskMap.entity.EmployeeDetails;
import com.example.demo.TaskMap.repository.EmployeeRepository;
import com.example.demo.TaskMap.repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;


    public Employee saveEmployee(String employeeName, MultipartFile employeeImage, Long employeeDetailsId) throws IOException {
        Optional<EmployeeDetails> employeeDetails = employeeDetailsRepository.findById(employeeDetailsId);
        if (employeeDetails.isPresent()) {
            Employee employee = new Employee();
            employee.setEmployeeName(employeeName);
            employee.setEmployeeDetails(employeeDetails.get());
            employee.setImage(employeeImage.getBytes());
            return employeeRepository.save(employee);
        } else {
            throw new IllegalArgumentException("Invalid Employee Details ID");
        }
    }


    public Employee updateEmployee(Long id, String employeeName, MultipartFile employeeImage, Long employeeDetailsId) throws IOException {
        Optional<Employee> existingEmployeeOpt = employeeRepository.findById(id);
        if (existingEmployeeOpt.isPresent()) {
            Employee existingEmployee = existingEmployeeOpt.get();
            existingEmployee.setEmployeeName(employeeName);
            existingEmployee.setImage(employeeImage.getBytes());
            Optional<EmployeeDetails> employeeDetails = employeeDetailsRepository.findById(employeeDetailsId);
            employeeDetails.ifPresent(existingEmployee::setEmployeeDetails);
            return employeeRepository.save(existingEmployee);
        } else {
            throw new IllegalArgumentException("Employee not found");
        }
    }

    public List<Employee> searchByEmployeeName(String employeeName) {
        return employeeRepository.findByEmployeeName(employeeName);
    }
    public List<Employee> searchByEmployeeSkill(String employeeSkill) {
        return employeeRepository.findByEmployeeDetails_EmployeeSkill(employeeSkill);
    }
    public List<Employee> searchByEmployeeRoll(String employeeRoll) {
        return employeeRepository.findByEmployeeDetails_EmployeeRoll(employeeRoll);
    }
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findByIdNative(id);
    }


    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
