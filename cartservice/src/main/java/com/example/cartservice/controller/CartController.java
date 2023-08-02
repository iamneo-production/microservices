package com.example.cartservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CartController {
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductServiceProxy proxy;

	List<Cart> mycart = new ArrayList<Cart>();

	@GetMapping("/home")
	public String getMycart() {
		String getHome = proxy.getHome();
		return getHome;
	}

	@HystrixCommand(fallbackMethod = "addMyCartFallBack")
	@GetMapping("/mycart")
	public List<Cart> myCart() {
		List<Product> l = proxy.showProductDetails();
		l.forEach(product -> {
			Cart c = new Cart(product.getId(), product.getProductId(), product.getDescription(), product.getPrice(), 1,
					product.getPortNumber());
			mycart.add(c);
		});
		logger.info("Response::" + mycart);

		return mycart;
	}

	@PostMapping("/addCart")
	public List<Cart> addToCart(@RequestBody Cart cart){
		mycart.add(cart);
		return mycart;
	}

	public List<Cart> addMyCartFallBack() {
		System.out.println("Product Service is down!!! fallback route enabled...");
		List<Cart> mycart = new ArrayList<Cart>();
		Cart cart = new Cart(0, "00", "Dummy", 0000, 1, "port");
		mycart.add(cart);
		return mycart;
	}
}