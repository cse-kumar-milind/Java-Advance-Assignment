package com.app.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.movie.model.Movie;

@Service
public class MovieService {
	
    private List<Movie> movies = new ArrayList<>(List.of(
            new Movie(1L, "Inception", "English", 250.0),
            new Movie(2L, "RRR", "Telugu", 200.0),
            new Movie(3L, "3 Idiots", "Hindi", 150.0),
            new Movie(4L, "Interstellar", "English", 300.0),
            new Movie(5L, "KGF Chapter 2", "Kannada", 180.0)
    ));
	
	
	
	public Movie createMovie(Movie movie) {
		
		movies.add(movie);
		return movie;
	}
	
	public List<Movie> getAllMovies(){
		return movies;
	}
	
	public Movie getMovieById(Long id) {
		return movies.stream().filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Movie not found with id: "+id));
	}
	
}
