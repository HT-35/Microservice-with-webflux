package com.example.service2.model;

public class Order {
	private String id;
	private String productId;
	private int quantity;

	public Order() {
	}

	public Order(String id, String productId, int quantity) {
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}