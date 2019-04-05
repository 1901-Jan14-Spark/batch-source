package com.revature.message;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	
	private final Logger log = Logger.getLogger(ConsumerService.class);
	
	@KafkaListener(topics= "test-1")
	public void consume(String message) {
		log.info("consumed message ------> "+ message );
	}

}
