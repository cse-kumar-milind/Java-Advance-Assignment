package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {
	
	private Engine engine;
	
	@Autowired
	public Car(Engine engine) {
		this.engine = engine;
	}
	
	

}
