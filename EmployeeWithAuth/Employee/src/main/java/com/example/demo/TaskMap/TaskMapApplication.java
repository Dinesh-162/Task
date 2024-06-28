package com.example.demo.TaskMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaskMapApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskMapApplication.class, args);
	}

}
