package com.app.booking.publisher;

import com.app.booking.dto.BookingMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.rabbitmq.exchange}")
    private String exchange;

    @Value("${app.rabbitmq.routing-key}")
    private String routingKey;

    public void publishBooking(BookingMessage message) {

        rabbitTemplate.convertAndSend(exchange, routingKey, message);

        System.out.println("📤 Sent with key: " + routingKey);
    }
}