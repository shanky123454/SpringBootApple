package in.com.dao;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.SimpleLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Customer {

	private static final Logger log = LoggerFactory.getLogger(Customer.class);

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Customer.class);

	static {
		
		SimpleLayout layout = new SimpleLayout();
		ConsoleAppender appender = new ConsoleAppender(layout);
		logger.addAppender(appender);
		logger.setLevel(Level.ALL);
	}
	
	
	public int getCustomer() {
		log.info("customer is present with given id");
		return 5;
	}
	
	public void insertCustomer() {
		logger.trace("customer is inserted with given id");
		
	}
	
}
