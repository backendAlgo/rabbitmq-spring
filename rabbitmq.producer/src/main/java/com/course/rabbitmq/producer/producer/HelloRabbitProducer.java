package com.course.rabbitmq.producer.producer;
/* Mirshod created on 4/26/2021 */

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloRabbitProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendHello(String name) {
        rabbitTemplate.convertAndSend("course.first", "Hello " + name);
    }
}
