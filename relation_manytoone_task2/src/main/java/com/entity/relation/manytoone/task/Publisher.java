package com.entity.relation.manytoone.task;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Publisher {
	@Id
	@Column(name = "publisher_id")
	private long id;
	
	@Column(name = "publisher_name")
	private String name;
	private String location;
	
	@OneToMany(mappedBy = "publisher")
	private List<Book> books;
	
	public Publisher() {
	}

	public Publisher(Long id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

	
	
	
}
