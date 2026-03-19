package com.app.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestaurantDto {
	private Long id;
	private String name;
	private String location;
	private String cuisineType;
	private Boolean available;
}
