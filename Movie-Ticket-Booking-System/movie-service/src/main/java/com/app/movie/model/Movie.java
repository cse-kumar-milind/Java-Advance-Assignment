package com.app.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Movie {
	
	private Long id;
	private String name;
	private String language;
	private Double price;
}
