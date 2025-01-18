package com.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springbootkafka.model.User;

@Service
public class JsonKafkaConsumer {

	private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics = "json_kafka_topic" , groupId = "myGroup")
	public void consume(User user) {
		logger.info(String.format("Json message recived -> %s", user.toString()));
	}
	
}
