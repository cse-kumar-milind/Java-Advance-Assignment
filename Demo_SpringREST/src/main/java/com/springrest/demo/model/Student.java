package com.springrest.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private long id;
	
	@Column(name = "student_name", nullable = false)
	private String name;
	
	@Column(name = "student_email")
	private String email;
	
	@Column(name = "student_contact_number", nullable = false)
//	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Contact Number must be of 10 digits")
	private String contactNumber;
	
	public Student() {
		
	}

	public Student(String name, String email, String contactNumber) {
		super();
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	
	
}
