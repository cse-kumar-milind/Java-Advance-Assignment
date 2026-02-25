package com.entity.relation.manytomany;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToMany
	private Set<Employee> employees;
	
	public Project() {
	}

	public Project(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "\nProject [\nid: " + id + "\nname: " + name + "\n]";
	}
	
	

}
