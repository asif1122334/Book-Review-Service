package com.mobilefirst.bookreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookReviewServiceApplication.class, args);
	}

}
