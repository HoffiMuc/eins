package com.example.demo;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static AtomicInteger counter = new AtomicInteger(0);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

