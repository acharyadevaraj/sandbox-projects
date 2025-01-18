package com.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	/**
	 * When ever Kafka producer will send the message to the kafka topic and this
	 * method will consumes those messages.
	 * 
	 * @KafkaListener annotation to subscribe the topic.
	 * @param message
	 */
	@KafkaListener(topics = "BasicTopic", groupId = "myGroup")
	public void consume(String message) {
		logger.info(message.format("Message recived :  %s", message));

	}
}
