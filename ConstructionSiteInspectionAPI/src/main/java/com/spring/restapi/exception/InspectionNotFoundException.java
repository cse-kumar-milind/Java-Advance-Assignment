package com.spring.restapi.exception;

public class InspectionNotFoundException extends RuntimeException{

	public InspectionNotFoundException(String message) {
		super(message);
	}
	
}
