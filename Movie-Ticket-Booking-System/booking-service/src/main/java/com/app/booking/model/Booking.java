package com.app.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Booking {
	
	private Long bookingId;
	private Long movieId;
	private String movieName;
	private String customerName;
	private Integer tickets;
	private Double totalAmount;
	private String status;
	
}
