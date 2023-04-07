package com.test.spring_boot_lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.test")
public class SpringBootLessonApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLessonApplication.class, args);
	}
}
