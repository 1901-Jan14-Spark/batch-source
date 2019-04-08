package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.revature.filter.AuthFilter;
import com.revature.filter.LoggingFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	public LoggingFilter loggingFilter() {
		return new LoggingFilter();
	}
	
	@Bean 
	public AuthFilter authFilter() {
		return new AuthFilter();
	}
	
}
