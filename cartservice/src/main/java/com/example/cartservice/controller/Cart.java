package com.example.cartservice.controller;

public class Cart {
    private Integer id;
    private String productId;
    private String description;
    private double price;
    private String port;
    private Integer quantity;
    

	public Cart() {
		// TODO Auto-generated constructor stub
	}
    public Cart(Integer id,String productId,String description,double price,Integer quantity,String port){
    	this.id=id;
    	this.productId=productId;
    	this.description=description;
    	this.price=price;
    	this.quantity=quantity;
    	this.port=port;
    	
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
    public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
    
}