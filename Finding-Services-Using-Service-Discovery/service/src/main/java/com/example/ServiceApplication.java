package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Annotation to enable a DiscoveryClient implementation.
@EnableDiscoveryClient

@SpringBootApplication
@RestController
public class ServiceApplication {
	@Value("${service.instance.name}")
	private String instance;
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@GetMapping("/")
	public String message() {
		return "Hello from " + instance;
	}
}
