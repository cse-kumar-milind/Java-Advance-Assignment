package com.app.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.order.client.RestaurantClient;
import com.app.order.dto.RestaurantDto;
import com.app.order.model.Order;
import com.app.order.repository.OrderRepository;

@Service
public class OrderService {
	
	private OrderRepository repository;
	private RestaurantClient restaurantClient;
	
	public OrderService(OrderRepository repository, RestaurantClient restaurantClient) {
		this.repository = repository;
		this.restaurantClient = restaurantClient;
	}
	
	public Order createOrder(Order order) {
		
		RestaurantDto restaurant = restaurantClient.getRestaurantById(order.getRestaurantId());
		
		if(!restaurant.getAvailable()) {
			throw new RuntimeException(restaurant.getName().equals("Service Unavailable")
	                ? "Restaurant Service is currently down. Please try again later."
	                        : "Restaurant " + restaurant.getName() + " is not available.");
		}
		
		order.setRestaurantName(restaurant.getName());
		
		return repository.save(order);
	}
	
	public List<Order> getAllOrders(){
		return repository.findAll();
	}
	
	public Order getOrderById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id: "+id));
	}
}
