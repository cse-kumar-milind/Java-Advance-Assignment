package com.usermanagement.restapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	
	public enum Role{
		ADMIN,USER
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 3)
	@NotBlank(message = "Required field!")
	private String fullName;
	
	@NotBlank(message = "Required field!")
	@Column(unique = true)
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
	message = "Email should be in format: example@example.com")
	private String email;
	
	@NotBlank
	@Size(min = 8)
	private String password;
	
	@Min(18)
	@Max(60)
	private Long age;
	
	@Enumerated(EnumType.STRING)
	private Role role = Role.USER;
	
	public User() {
		
	}

	public User(String fullName, String email, String password, Long age, Role role) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.age = age;
		this.role = role;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	
	
	
}
