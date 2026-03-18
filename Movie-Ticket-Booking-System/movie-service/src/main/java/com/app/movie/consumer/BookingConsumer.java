package com.app.movie.consumer;

import com.app.movie.dto.BookingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookingConsumer {

	@RabbitListener(queues = "${app.rabbitmq.queue}")
	public void consume(BookingMessage message) {
	    System.out.println("🎬 Received: " + message);
	}
}