package com.example.demo.TaskMap.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String employeeName;

    @ManyToOne
    @JoinColumn(name = "roll_id")
    private EmployeeRoll employeeRoll;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private EmployeeSkills employeeSkills;
}
