package com.example.demo.TaskMap.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Data
@Entity
public class EmployeeRoll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeRollId;

    private String employeeRoll;

    @OneToMany(mappedBy = "employeeRoll")
    private List<Employee> employees;
}

