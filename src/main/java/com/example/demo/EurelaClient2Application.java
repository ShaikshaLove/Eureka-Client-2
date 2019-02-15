package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class EurelaClient2Application {

	@Autowired
	private RestTemplate rt;
	public static void main(String[] args) {
		SpringApplication.run(EurelaClient2Application.class, args);
	}
	
	@GetMapping("/hi")
	public String heyy() {
		String url="http://EUREKA-CLIENT1/greet";
		return rt.getForObject(url, String.class);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate rt() {
		return new RestTemplate();
	}

}

