package com.example.multidispatcherissue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MultiDispatcherIssueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiDispatcherIssueApplication.class, args);
	}

	/**
	 * @author Filip Hrisafov
	 */
	@RestController
	public static class TestController {

			@GetMapping("/something")
			public String test() {
					return "test";
			}
	}
}
