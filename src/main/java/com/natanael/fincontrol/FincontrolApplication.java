package com.natanael.fincontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController 
public class FincontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(FincontrolApplication.class, args);
	}

	@GetMapping ("/hello")
	public String hello (@RequestParam(defaultValue = "World") String name) {
		
		return String.format("Hello %s", name + '!' +'\n');
	}

}
