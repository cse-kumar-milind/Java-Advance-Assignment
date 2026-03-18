package com.app.movie.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingMessage {
    private Long bookingId;
    private String customerName;
    private String movieName;
    private int tickets;
    private double totalAmount;
    private String status;
}