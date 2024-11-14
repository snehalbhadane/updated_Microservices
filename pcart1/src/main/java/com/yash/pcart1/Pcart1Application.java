package com.yash.pcart1;



import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;
@EnableDiscoveryClient
//@EnableWebFlux
//@ComponentScan("com.yash.pcart1.controller")
@SpringBootApplication
public class Pcart1Application 
{
	@Bean
	public WebClient.Builder getWebClientBuilder()
	{
		return WebClient.builder();
	}
	public static void main(String[] args) {
		SpringApplication.run(Pcart1Application.class, args);
	}
}
