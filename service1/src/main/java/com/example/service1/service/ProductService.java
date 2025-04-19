package com.example.service1.service;

import com.example.service1.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

	private final Map<String, Product> products = new HashMap<>();

	public ProductService() {
		// Add some sample data
		products.put("1", new Product("1", "Laptop", 1200.0));
		products.put("2", new Product("2", "Smartphone", 800.0));
		products.put("3", new Product("3", "Tablet", 500.0));
	}

	public List<Product> getAllProducts() {
		return new ArrayList<>(products.values());
	}

	public Product getProductById(String id) {
		return products.get(id);
	}

	public Product createProduct(Product product) {
		products.put(product.getId(), product);
		return product;
	}

	public Product updateProduct(String id, Product product) {
		if (products.containsKey(id)) {
			product.setId(id);
			products.put(id, product);
			return product;
		}
		return null;
	}

	public boolean deleteProduct(String id) {
		if (products.containsKey(id)) {
			products.remove(id);
			return true;
		}
		return false;
	}
}