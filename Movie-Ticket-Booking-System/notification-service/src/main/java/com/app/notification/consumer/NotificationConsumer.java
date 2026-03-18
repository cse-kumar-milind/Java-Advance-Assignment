package com.app.notification.consumer;

import com.app.notification.dto.BookingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationConsumer {

	@RabbitListener(queues = "${app.rabbitmq.queue}")
	public void consume(BookingMessage message) {
	    System.out.println("📩 Notification: " + message);
	}
}