package com.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.payment.client.ClientRestRequest;
import com.payment.client.ClientRestRequestImpl;
import com.payment.service.ContoService;
import com.payment.service.ContoServiceImpl;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
	
	@Bean
	public ContoService contoService() {
		ContoService contoService = new ContoServiceImpl();
		return contoService;
	}

	@Bean
	public ClientRestRequest restRequest() {
		ClientRestRequest restRequest = new ClientRestRequestImpl();
		return restRequest;
	}
	
	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

}
