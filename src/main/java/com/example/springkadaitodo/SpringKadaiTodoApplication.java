package com.example.springkadaitodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.springkadaitodo.repository")
@EntityScan(basePackages = "com.example.springkadaitodo.entity")
public class SpringKadaiTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKadaiTodoApplication.class, args);
	}

}