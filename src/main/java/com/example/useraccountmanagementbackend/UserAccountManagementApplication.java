package com.example.useraccountmanagementbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class UserAccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAccountManagementApplication.class, args);
	}

}
