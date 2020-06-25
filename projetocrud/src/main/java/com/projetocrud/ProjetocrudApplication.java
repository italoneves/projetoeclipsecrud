package com.projetocrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjetocrudApplication{

	public static void main(String[] args) {
		SpringApplication.run(ProjetocrudApplication.class, args);
	   
		System.out.println(new BCryptPasswordEncoder().encode("123"));
		
	}

	

}
