package com.app.movie.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.movie.model.Movie;
import com.app.movie.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/movies")
public class MovieController {
	
	private MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@PostMapping
	public ResponseEntity<Movie> create(@RequestBody Movie movie){
		return new ResponseEntity<>(movieService.createMovie(movie),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Movie>> getAll() {
		return ResponseEntity.ok(movieService.getAllMovies());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getById(@PathVariable Long id){
		return ResponseEntity.ok(movieService.getMovieById(id));
	}
	
}
