package com.app.booking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieDto {
	private Long id;
	private String name;
	private String language;
	private Double price;
}
