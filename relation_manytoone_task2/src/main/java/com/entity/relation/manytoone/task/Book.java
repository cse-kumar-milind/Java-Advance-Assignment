package com.entity.relation.manytoone.task;


import jakarta.persistence.*;

@Entity
public class Book {
	@Id
	@Column(name = "book_id")
	private long id;
	
	private String title;
	private double price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
	
	public Book() {
	}

	public Book(Long id, String title, double price, Publisher publisher) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.publisher = publisher;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + "]";
	}

	
	
	
	

}
