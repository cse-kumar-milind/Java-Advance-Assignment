package com.app.restaurant.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.restaurant.model.Restaurant;
import com.app.restaurant.service.RestaurantService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	private RestaurantService service;
	
	@GetMapping
	public ResponseEntity<List<Restaurant>> getAll(){
		return ResponseEntity.ok(service.getAllRestaurants());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getRestaurantById(id));
	}
	
	@PostMapping
	public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant){
		return new ResponseEntity<>(service.createRestaurant(restaurant),HttpStatus.CREATED);
	}
	
	
}
