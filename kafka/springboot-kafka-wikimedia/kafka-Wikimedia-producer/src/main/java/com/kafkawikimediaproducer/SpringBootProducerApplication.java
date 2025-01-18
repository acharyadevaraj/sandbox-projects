package com.kafkawikimediaproducer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafkawikimediaproducer.config.KafkaWikimediaProducer;

@SpringBootApplication
public class SpringBootProducerApplication {

	@Autowired
	private KafkaWikimediaProducer kafkaWikimediaProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProducerApplication.class);
	}

	@PostConstruct
	public void init() throws InterruptedException {
		kafkaWikimediaProducer.sendMessage();
	}
}
