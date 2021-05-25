package com.devasurya.ideaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class IdeaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdeaAppApplication.class, args);
	}

}
