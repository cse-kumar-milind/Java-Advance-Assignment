package com.spring.restapi.exception;


public class BookNotFoundException extends RuntimeException{

	public BookNotFoundException(String message) {
		super(message);
		
	}
	
	
}
