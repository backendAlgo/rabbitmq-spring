package com.course.rabbitmq.consumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/* Mirshod created on 4/26/2021 */
@Service
public class HelloRabbitConsumer {
    @RabbitListener(queues = "course.first")
    public void listener(String message) {
        System.out.println("Consuming " + message);
    }
}
