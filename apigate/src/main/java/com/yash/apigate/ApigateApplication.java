package com.yash.apigate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigateApplication.class, args);
	}

}
