package com.example.productservice.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	private org.slf4j.Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	Environment environment;
	String port=null;
	
	@GetMapping("/home")
	public String home(){
		port=environment.getProperty("local.server.port");
		logger.info("port:: "+port);
		return "Welcome to product home page "+ port;
	}

	@PostMapping("/addProduct")
	public double addProduct(@RequestBody Product product){
		System.out.println("Product "+ product.getPrice());
		return product.getPrice();
	}

	@GetMapping("/auth")
    public String getItems(@RequestHeader("Authorization") String authorizationHeader) {
        // Validate JWT token from the Authorization header
        String token = authorizationHeader.replace("Bearer ", "");

        try {
			if(token.equals("hskdfjUTustRgahsgd")) {
				return "Hello, User.";
			}
			else {
				return "You don't have access to this resouce";
			}
            // Return the list of items (or any other data) if the token is valid.
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid token");
        }
    }

	@GetMapping("/products")
	public List<Product> showProductDetails(){
		port=environment.getProperty("local.server.port");
		Product p=new Product(1,"12","APPle",48000,port);
		Product p1=new Product(2,"23","Samsung",35000,port);
		Product p2=new Product(3,"45","MI",30000,port);
		Product p3=new Product(4,"167","OPPO",25000,port);
		
		List<Product> listOfProducts=Arrays.asList(p,p1,p2,p3);
		logger.info("listofProducts::"+listOfProducts);
		listOfProducts.forEach(product->{
			logger.info("product::"+product.toString());
		});
		
		return listOfProducts;
		
	}

}
