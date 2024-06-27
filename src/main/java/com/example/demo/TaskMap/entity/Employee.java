package com.example.demo.TaskMap.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Lob
    @Column(columnDefinition ="BLOB")
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "details_id")
    @JsonIgnoreProperties("employees")
    private EmployeeDetails employeeDetails;

}
