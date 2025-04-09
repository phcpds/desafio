package com.desafio.producerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class ProducerapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerapiApplication.class, args);
	}

}
