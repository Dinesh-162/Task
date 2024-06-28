package com.example.demo.TaskMap.controller;

import com.example.demo.TaskMap.entity.Employee;
import com.example.demo.TaskMap.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/admin/saveEmployee")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Employee> saveEmployee(@RequestParam("employeeName") String employeeName,
                                                 @RequestParam("employeeImage") MultipartFile employeeImage,
                                                 @RequestParam("employeeDetailsId") Long employeeDetailsId) throws IOException {
        Employee savedEmployee = employeeService.saveEmployee(employeeName, employeeImage, employeeDetailsId);
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("/admin/updateEmployee/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @RequestParam("employeeName") String employeeName,
                                                   @RequestParam("employeeImage") MultipartFile employeeImage,
                                                   @RequestParam("employeeDetailsId") Long employeeDetailsId) throws IOException {
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeName, employeeImage, employeeDetailsId);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/admin/user/getEmployee/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/admin/user/searchByName")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Employee> searchByEmployeeName(@RequestParam String name) {
        return employeeService.searchByEmployeeName(name);
    }

    @GetMapping("/admin/user/searchBySkill")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Employee> searchByEmployeeSkill(@RequestParam String skill) {
        return employeeService.searchByEmployeeSkill(skill);
    }

    @GetMapping("/admin/user/searchByRoll")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Employee> searchByEmployeeRoll(@RequestParam String roll) {
        return employeeService.searchByEmployeeRoll(roll);
    }

    @DeleteMapping("/admin/deleteEmployee/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        boolean isRemoved = employeeService.deleteEmployee(id);
        if (isRemoved) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
