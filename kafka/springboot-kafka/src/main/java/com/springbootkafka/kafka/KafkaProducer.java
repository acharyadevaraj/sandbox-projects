package com.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

	// Spring boot will provide the auto configuration for Kafka Template.
	// KafkaTemplate I Used to send the message from the producers.
	private KafkaTemplate<String, String> kafkeTemplate;

	public KafkaProducer(KafkaTemplate<String, String> kafkeTemplate) {
		super();
		this.kafkeTemplate = kafkeTemplate;
	}

	public void sendMessage(String message) {
		logger.info(message.format("Message Sent %s", message));
		kafkeTemplate.send("BasicTopic", message);
	}

}
