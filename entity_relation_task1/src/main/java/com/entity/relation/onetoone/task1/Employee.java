package com.entity.relation.onetoone.task1;

import jakarta.persistence.*;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String department;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Locker locker;
	
	
}
