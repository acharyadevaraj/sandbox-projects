package com.kafkawikimediaproducer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikiMediaHandler implements EventHandler {

	private KafkaTemplate<String, String> kafkaTemplate;
	private String topic;
	private static final Logger logger = LoggerFactory.getLogger(WikiMediaHandler.class);

	public WikiMediaHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub

	}

	//When ever the new event is occurred in the wikimedia this method will be triggered.
	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		logger.info(String.format("Event data : %s", messageEvent.getData()));
		kafkaTemplate.send(topic, messageEvent.getData());
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub

	}

}
