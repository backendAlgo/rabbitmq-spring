package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.producer.HelloRabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private HelloRabbitProducer producer;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.sendHello("Mirshodjon Mirjonov " + Math.random());
	}
}
