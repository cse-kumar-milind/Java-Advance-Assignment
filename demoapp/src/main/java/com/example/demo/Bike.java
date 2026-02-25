package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{
	
	private Engine engine;
	
	@Autowired
	public Bike(Engine engine) {
		this.engine = engine;
	}
	

}
