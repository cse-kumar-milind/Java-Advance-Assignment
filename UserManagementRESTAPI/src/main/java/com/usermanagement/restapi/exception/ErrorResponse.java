package com.usermanagement.restapi.exception;

import java.util.Map;

public class ErrorResponse {
	
	private int status;
	private String message;
	private Map<String, String> validationErrors;
	
	
	public ErrorResponse(int status, String message, Map<String, String> validationErrors) {
		super();
		this.status = status;
		this.message = message;
		this.validationErrors = validationErrors;
	}
	
	
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public Map<String, String> getValidationErrors() {
		return validationErrors;
	}
	
	
	
	
	
	

}
