package com.kafkawikimediaconsumer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafkawikimediaconsumer.model.WikiMediaData;
import com.kafkawikimediaconsumer.repo.WikiMediaDataRepo;

@Service
public class KafkaWikimediaConsumer {

	@Autowired
	private WikiMediaDataRepo wikiMediaDataRepo;

	private static final Logger logger = LoggerFactory.getLogger(KafkaWikimediaConsumer.class);

	@KafkaListener(topics = "wikimedia_topic", groupId = "myGroup")
	public void consume(String eventMessage) {
		logger.info(String.format("Event Message recived : %s", eventMessage));
		WikiMediaData wikiMediaData = new WikiMediaData();
		wikiMediaData.setWikiEventData(eventMessage);
		try {
			wikiMediaDataRepo.save(wikiMediaData);
		} catch (Exception e) {
			System.out.println("Failed to save the data");
		}
		
	}
}
