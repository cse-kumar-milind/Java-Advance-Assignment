package com.spring.restapi.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404 - Inspection not found
    @ExceptionHandler(InspectionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            InspectionNotFoundException e, HttpServletRequest request) {

        return new ResponseEntity<>(
                new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(),
                        request.getRequestURI()),
                HttpStatus.NOT_FOUND);
    }

    // 400 - Invalid file type or empty file
    @ExceptionHandler(InvalidFileException.class)
    public ResponseEntity<ErrorResponse> handleInvalidFile(
            InvalidFileException e, HttpServletRequest request) {

        return new ResponseEntity<>(
                new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                        request.getRequestURI()),
                HttpStatus.BAD_REQUEST);
    }

    // 400 - Validation errors (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            MethodArgumentNotValidException e, HttpServletRequest request) {

        return new ResponseEntity<>(
                new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Validation Failed",
                        request.getRequestURI()),
                HttpStatus.BAD_REQUEST);
    }

    // 413 - File size exceeds limit (5MB)
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ErrorResponse> handleMaxSize(
            MaxUploadSizeExceededException e, HttpServletRequest request) {

        return new ResponseEntity<>(
                new ErrorResponse(HttpStatus.CONTENT_TOO_LARGE.value(),
                        "File size exceeds the 5MB limit",
                        request.getRequestURI()),
                HttpStatus.CONTENT_TOO_LARGE);
    }

    // 500 - Catch-all
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobal(
            Exception e, HttpServletRequest request) {

        return new ResponseEntity<>(
                new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),
                        request.getRequestURI()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}