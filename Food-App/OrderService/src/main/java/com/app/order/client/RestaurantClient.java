package com.app.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.order.dto.RestaurantDto;

@FeignClient(name = "restaurant-service", fallback = RestaurantFallback.class)
public interface RestaurantClient {
	
	@GetMapping("/restaurants/{id}")
	RestaurantDto getRestaurantById(@PathVariable Long id);
}
