package com.example.demoSSH;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demoSSH.dao.EmployeeRepository;
import com.example.demoSSH.entity.Employee;
import com.example.demoSSH.util.Quote;



@SpringBootApplication
public class DemoSshApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DemoSshApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoSshApplication.class, args);
	}
	
}
