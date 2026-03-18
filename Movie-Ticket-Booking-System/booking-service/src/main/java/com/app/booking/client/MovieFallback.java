package com.app.booking.client;

import org.springframework.stereotype.Component;

import com.app.booking.dto.MovieDto;

@Component
public class MovieFallback implements MovieClient{
	
	@Override
	public MovieDto getMovieById(Long id) {
		
		MovieDto movie = new MovieDto();
		
		movie.setId(id);
		movie.setName("Service Unavailable");
		movie.setLanguage("N/A");
		movie.setPrice(0.0);
		
		return movie;
	}
}
