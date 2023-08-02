package com.example.cartservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableFeignClients
@ComponentScan("com.example.cartservice")
@EnableDiscoveryClient
@EnableHystrix
public class CartserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartserviceApplication.class, args);
	}

}
