package com.yash.apig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigApplication.class, args);
	}

}
