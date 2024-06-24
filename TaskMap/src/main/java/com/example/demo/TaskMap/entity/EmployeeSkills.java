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
public class EmployeeSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeSkillId;

    private String employeeSkill;

    @OneToMany(mappedBy = "employeeSkills")
    private List<Employee> employees;
}
