package com.employee.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.employee.management")
public class EmployeeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeBackendApplication.class, args);
	}

}
