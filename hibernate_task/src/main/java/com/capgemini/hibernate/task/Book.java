package com.capgemini.hibernate.task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "library_books")

public class Book {
	@Id
	@Column(name = "book_id")
	private int book_id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "author_name", nullable = false)
	private String authorName;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "availability_status")
	private String availabilityStatus;
	
	@Column(name = "published_year")
	private int publishedYear;

	public Book() {
		super();
	}

	public Book(int book_id, String title, String authorName, String genre, double price, String availabilityStatus,
			int publishedYear) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.authorName = authorName;
		this.genre = genre;
		this.price = price;
		this.availabilityStatus = availabilityStatus;
		this.publishedYear = publishedYear;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", title=" + title + ", authorName=" + authorName + ", genre=" + genre
				+ ", price=" + price + ", availabilityStatus=" + availabilityStatus + ", publishedYear=" + publishedYear
				+ "]";
	}
	
	
	
	
	
	
}
