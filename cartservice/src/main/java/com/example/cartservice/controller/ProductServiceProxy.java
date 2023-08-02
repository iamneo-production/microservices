package com.example.cartservice.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("product-service")
public interface ProductServiceProxy {
	@GetMapping("/products")
	public List<Product> showProductDetails();

	@GetMapping("/home")
	public String getHome();
}