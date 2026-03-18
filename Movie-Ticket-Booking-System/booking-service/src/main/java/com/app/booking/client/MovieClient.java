package com.app.booking.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.booking.dto.MovieDto;

@FeignClient(name = "MOVIE-SERVICE", fallback = MovieFallback.class)
public interface MovieClient {
	
	@GetMapping("/movies/{id}")
	MovieDto getMovieById(@PathVariable Long id);

}
