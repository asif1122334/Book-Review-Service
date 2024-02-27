package com.mobilefirst.bookreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookReviewServiceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookReviewServiceEurekaServerApplication.class, args);
	}

}
