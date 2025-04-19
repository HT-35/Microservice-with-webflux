package com.example.service2.service;

import com.example.service2.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

	private final Map<String, Order> orders = new HashMap<>();

	public OrderService() {
		// Add some sample data
		orders.put("1", new Order("1", "1", 2));
		orders.put("2", new Order("2", "2", 1));
		orders.put("3", new Order("3", "1", 3));
	}

	public List<Order> getAllOrders() {
		return new ArrayList<>(orders.values());
	}

	public Order getOrderById(String id) {
		return orders.get(id);
	}

	public List<Order> getOrdersByProductId(String productId) {
		return orders.values().stream()
				.filter(order -> order.getProductId().equals(productId))
				.collect(Collectors.toList());
	}

	public Order createOrder(Order order) {
		orders.put(order.getId(), order);
		return order;
	}

	public Order updateOrder(String id, Order order) {
		if (orders.containsKey(id)) {
			order.setId(id);
			orders.put(id, order);
			return order;
		}
		return null;
	}

	public boolean deleteOrder(String id) {
		if (orders.containsKey(id)) {
			orders.remove(id);
			return true;
		}
		return false;
	}

	public String getOrderInfoSummary(String productId) {
		List<Order> productOrders = getOrdersByProductId(productId);
		int totalQuantity = productOrders.stream().mapToInt(Order::getQuantity).sum();
		return "Total orders: " + productOrders.size() + ", Total quantity: " + totalQuantity;
	}
}