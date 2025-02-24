package com.kafkawikimediaproducer.config;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class KafkaWikimediaProducer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaWikimediaProducer.class);

	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaWikimediaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage() throws InterruptedException {
		String topic = "wikimedia_topic";

		// to read real time data from wikimedia, we use event source

		EventHandler eventHandler = new WikiMediaHandler(kafkaTemplate, topic);
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
		EventSource eventSource = builder.build();
		eventSource.start();
		TimeUnit.MINUTES.sleep(10);
	}

}
