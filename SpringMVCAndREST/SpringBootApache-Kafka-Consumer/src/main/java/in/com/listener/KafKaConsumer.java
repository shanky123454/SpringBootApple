package in.com.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import in.com.utils.AppConstants;

@Component
public class KafKaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);

	/*
	 * A group ID is a vital part of consumer configuration in Apache Kafka because
	 * it determines which group a consumer belongs to
	 */
    @KafkaListener(topics = AppConstants.TOPIC_NAME,
                    groupId = AppConstants.GROUP_ID)
    public void consume(String message){
    	System.out.println(message);
        LOGGER.info(String.format("Message received -> %s", message));
    }
}
