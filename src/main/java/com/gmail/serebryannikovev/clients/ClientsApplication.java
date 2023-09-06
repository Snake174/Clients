package com.gmail.serebryannikovev.clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientsApplication {
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "clients");
		SpringApplication.run(ClientsApplication.class, args);
	}
}
