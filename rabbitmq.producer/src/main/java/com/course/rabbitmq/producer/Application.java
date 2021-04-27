package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.course.rabbitmq.producer.producer.EmployeeJsonProducer;
import com.course.rabbitmq.producer.producer.HelloRabbitProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.stream.IntStream;

@SpringBootApplication
//@EnableScheduling
public class Application implements CommandLineRunner {
    @Autowired
    private EmployeeJsonProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        IntStream.range(0, 5)
                .forEach(i -> {
                    producer.sendMessage(
                            new Employee("emp" + i, "name" + i, LocalDate.now()));
                });
    }
}
