//package com.example.demo.TaskMap;
//
//import com.example.demo.TaskMap.entity.Employee;
//import com.example.demo.TaskMap.entity.EmployeeRoll;
//import com.example.demo.TaskMap.entity.EmployeeSkills;
//import com.example.demo.TaskMap.repository.EmployeeRepository;
//import com.example.demo.TaskMap.repository.EmployeeRollRepository;
//import com.example.demo.TaskMap.repository.EmployeeSkillsRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class LoadDatabase {
//
//    @Bean
//    CommandLineRunner initDatabase(EmployeeRepository employeeRepository,
//                                   EmployeeRollRepository employeeRollRepository,
//                                   EmployeeSkillsRepository employeeSkillsRepository) {
//        return args -> {
//            EmployeeRoll manager = new EmployeeRoll();
//            manager.setEmployeeRoll("Developer");
//            employeeRollRepository.save(manager);
//
//            EmployeeSkills javaSkill = new EmployeeSkills();
//            javaSkill.setEmployeeSkill("java");
//            employeeSkillsRepository.save(javaSkill);
//
//            Employee johnDoe = new Employee();
//            johnDoe.setEmployeeName("Dinesh");
//            johnDoe.setEmployeeRoll(manager);
//            johnDoe.setEmployeeSkills(javaSkill);
//            employeeRepository.save(johnDoe);
//        };
//    }
//}
