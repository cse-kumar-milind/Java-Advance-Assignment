package com.usermanagement.restapi.exception;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException e){
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException e, HttpServletRequest request){
		
		Map<String, String> errors = new HashMap<>();
		
		for(FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
				"Validation Failed!\n Invalid input data!!", errors); 
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobalException(Exception e, HttpServletRequest request){
		
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(), null);
		
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}