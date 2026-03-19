package com.app.order.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long restaurantId;
	private String restaurantName;
	private String customerName;
	private String foodItem;
	private Double amount;
	private String status;
	
	@Column(updatable = false)
	private LocalDateTime orderTime;
	
	@PrePersist
	protected void onCreate() {
		this.orderTime = LocalDateTime.now();
		this.status = "PLACED";
	}
	
	
}
