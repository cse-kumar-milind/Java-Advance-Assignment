package com.app.order.client;

import org.springframework.stereotype.Component;

import com.app.order.dto.RestaurantDto;

@Component
public class RestaurantFallback implements RestaurantClient{
	
	@Override
	public RestaurantDto getRestaurantById(Long id) {
		
		RestaurantDto fallback = new RestaurantDto();
		
		fallback.setId(id);
		fallback.setName("Service Unavailable");
		fallback.setAvailable(false);
		return fallback;
	}

}
