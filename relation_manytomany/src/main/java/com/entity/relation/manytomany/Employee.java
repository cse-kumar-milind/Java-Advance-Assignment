package com.entity.relation.manytomany;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_project", 
	joinColumns = @JoinColumn(name = "employee_id"), 
	inverseJoinColumns = @JoinColumn(name = "project_id"))
	private Set<Project> projects;
	
	public Employee() {
	}

	

	public Employee(String name, Set<Project> projects) {
		super();
		this.name = name;
		this.projects = projects;
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

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "\nEmployee [\nid: " + id + "\nname: " + name + "\n]";
	}
	
	

}
