package com.spring.restapi.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "title cannot be blank")
	private String title;
	
	@NotBlank(message = "author cannot be blank")
	private String author;
	
	@NotBlank(message = "genre cannot be blank")
	private String genre;
	
	@NotNull
	@Positive(message = "Price should be positive")
	private Double price;
	
	
	private LocalDate publishedDate;

	public Book() {
		
	}
	
	public Book(String title, String author, String genre,
			  Double price, LocalDate publishedDate) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.publishedDate = publishedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Long getId() {
		return id;
	}
	
	
}
