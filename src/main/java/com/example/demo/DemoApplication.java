package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Repo.Repository;

@SpringBootApplication
@RestController
public class DemoApplication {
	Repository repo;
	public DemoApplication() {
		super();
		repo = new Repository();
	}
	@GetMapping("/")
	public String Get()
	{
		String result = repo.GetUser("Andersen-1697811989106");
		return result;
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
