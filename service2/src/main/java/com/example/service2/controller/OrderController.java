package com.example.service2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service2.client.Service1Client;
import com.example.service2.model.Order;
import com.example.service2.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private Service1Client service1Client;

	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		return ResponseEntity.ok(orderService.getAllOrders());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable String id) {
		Order order = orderService.getOrderById(id);
		if (order != null) {
			return ResponseEntity.ok(order);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/by-product/{productId}")
	public ResponseEntity<List<Order>> getOrdersByProductId(@PathVariable String productId) {
		return ResponseEntity.ok(orderService.getOrdersByProductId(productId));
	}

	@GetMapping("/info/{productId}")
	public ResponseEntity<String> getOrderInfo(@PathVariable String productId) {
		return ResponseEntity.ok(orderService.getOrderInfoSummary(productId));
	}

	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable String id, @RequestBody Order order) {
		Order updatedOrder = orderService.updateOrder(id, order);
		if (updatedOrder != null) {
			return ResponseEntity.ok(updatedOrder);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
		if (orderService.deleteOrder(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}/product-info")
	public ResponseEntity<String> getProductInfoForOrder(@PathVariable String id) {

		System.out.println("getProductInfoForOrder" + id);

		Order order = orderService.getOrderById(id);
		if (order != null) {
			// Call Service 1 using WebFlux
			String productInfo = service1Client.getProductInfo(order.getProductId()).block();
			return ResponseEntity.ok("Order ID: " + id + ", " + productInfo);
		}
		return ResponseEntity.notFound().build();
	}
}