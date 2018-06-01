package com.example.demo;

import org.flowable.engine.ProcessEngine;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoDatasourceProblemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDatasourceProblemApplication.class, args);
	}

	@Bean
	public InitializingBean initializingBean(ProcessEngine processEngine) {
		return () -> {

		};
	}
}
