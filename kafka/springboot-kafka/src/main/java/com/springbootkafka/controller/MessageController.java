package com.springbootkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootkafka.kafka.JsonKafkaProducer;
import com.springbootkafka.kafka.KafkaProducer;
import com.springbootkafka.model.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

	@Autowired
	private KafkaProducer kafkaProducer;

	@Autowired
	private JsonKafkaProducer jsonKafkaProducer;

	// http:localhost:8080/api/v1/kafka/publish?message=Hello world
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message) {
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to the topic");
	}

	// http:localhost:8080/api/v1/kafka/publishJson
	@GetMapping("/publishJson")
	public ResponseEntity<String> publishJson(@RequestBody User user) {
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json message sent to the topic");

	}

}
