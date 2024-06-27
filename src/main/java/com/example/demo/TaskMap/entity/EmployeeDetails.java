package com.example.demo.TaskMap.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Data
@Entity
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeDetailsId;

    private String employeeRoll;

    private String employeeSkill;

    @OneToMany(mappedBy = "employeeDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("employeeDetails")
    private List<Employee> employees;
}
