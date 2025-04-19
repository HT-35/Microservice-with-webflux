package com.example.service1.controller;

import com.example.service1.model.Product;
import com.example.service1.service.ProductService;
import com.example.service1.client.Service2Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private Service2Client service2Client;

	@GetMapping("/{id}/order-info")
	public ResponseEntity<String> getProductOrderInfo(@PathVariable String id) {
		System.out.println("getProductOrderInfo" + id);
		Product product = productService.getProductById(id);
		if (product != null) {
			// Call Service 2 using WebFlux
			String orderInfo = service2Client.getOrderInfo(id).block();
			return ResponseEntity.ok("Product: " + product.getName() + ", " + orderInfo);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		System.out.println("getAllProducts");
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable String id) {
		Product product = productService.getProductById(id);
		if (product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(id, product);
		if (updatedProduct != null) {
			return ResponseEntity.ok(updatedProduct);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
		if (productService.deleteProduct(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}