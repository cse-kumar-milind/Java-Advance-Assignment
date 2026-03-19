package com.app.order.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.order.model.Order;
import com.app.order.service.OrderService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/orders")
public class OrderController {
	
	private OrderService service;
	
	@PostMapping
	public ResponseEntity<Order> create(@RequestBody Order order){
		return new ResponseEntity<>(service.createOrder(order),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getAll(){
		return ResponseEntity.ok(service.getAllOrders());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getById(@PathVariable Long id){
		return ResponseEntity.ok(service.getOrderById(id));
	}
}
