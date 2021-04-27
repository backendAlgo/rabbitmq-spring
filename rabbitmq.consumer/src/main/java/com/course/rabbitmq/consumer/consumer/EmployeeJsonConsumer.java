package com.course.rabbitmq.consumer.consumer;

import com.course.rabbitmq.consumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* Mirshod created on 4/27/2021 */
@Service
public class EmployeeJsonConsumer {
    @Autowired
    private ObjectMapper objectMapper;

    private final Logger LOG = LoggerFactory.getLogger(EmployeeJsonConsumer.class);

    @RabbitListener(queues = "course.employee")
    public void listen(String message) throws JsonProcessingException {
        var employee = objectMapper.readValue(message, Employee.class);

        LOG.info("Employee is {}", employee);
    }

}
