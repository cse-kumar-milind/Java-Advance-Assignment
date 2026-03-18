package com.app.booking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.dto.BookingRequest;
import com.app.booking.model.Booking;
import com.app.booking.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	private BookingService service;
	
	public BookingController(BookingService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Booking> create(@RequestBody BookingRequest request){
		
		return new ResponseEntity<>(service.createBooking(request),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Booking>> getAll(){
		return ResponseEntity.ok(service.getAllBookings());
	}
}
