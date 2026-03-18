package com.app.booking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingRequest {
	
	private Long movieId;
	private String customerName;
	private Integer tickets;
	
}
