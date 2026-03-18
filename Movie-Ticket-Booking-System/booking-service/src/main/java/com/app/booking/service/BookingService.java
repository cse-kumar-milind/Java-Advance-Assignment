package com.app.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.app.booking.client.MovieClient;
import com.app.booking.dto.BookingMessage;
import com.app.booking.dto.BookingRequest;
import com.app.booking.dto.MovieDto;
import com.app.booking.model.Booking;
import com.app.booking.publisher.BookingPublisher;

@Service
public class BookingService {
	
	private MovieClient movieClient;
	private BookingPublisher publisher;

	public BookingService(MovieClient movieClient,BookingPublisher publisher) {
		this.movieClient = movieClient;
		this.publisher = publisher;
	}
	
	private List<Booking> bookings = new ArrayList<>();
	private AtomicLong idGenerator = new AtomicLong(100);
	
	public Booking createBooking(BookingRequest request) {
		
		MovieDto movie = movieClient.getMovieById(request.getMovieId());
		
		if(movie.getName().equals("Service Unavailable")) {
			throw new RuntimeException("Movie Service is currently unavailable. Please try again later.");
		}
		
		Double totalAmount = movie.getPrice()*request.getTickets();
		
		Booking booking = new Booking(idGenerator.incrementAndGet(), request.getMovieId(), movie.getName(),
				request.getCustomerName(), request.getTickets(), totalAmount, "CONFIRMED");
		
		bookings.add(booking);
		
		BookingMessage message = BookingMessage.builder()
                .bookingId(booking.getBookingId())
                .customerName(booking.getCustomerName())
                .movieName(booking.getMovieName())
                .tickets(booking.getTickets())
                .totalAmount(booking.getTotalAmount())
                .status(booking.getStatus())
                .build();

        publisher.publishBooking(message);
		
		return booking;
		
	}
	
	public List<Booking> getAllBookings(){
		return bookings;
	}
}
