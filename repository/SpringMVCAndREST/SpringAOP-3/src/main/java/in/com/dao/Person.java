package in.com.dao;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.SimpleLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import in.com.mytransaction.MyTransaction;

@Component
public class Person {
		
	private static final Logger log = LoggerFactory.getLogger(Person.class);

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Person.class);

	static {
		
		SimpleLayout layout = new SimpleLayout();
		ConsoleAppender appender = new ConsoleAppender(layout);
		logger.addAppender(appender);
		logger.setLevel(Level.ALL);
	}
	
    @MyTransaction
	public void getPerson() {
		log.info("person is retreived");
	}
	
    @MyTransaction
	public Integer updatePerson()
	{
		logger.trace("person is updated");
		return 5;
		
	}
}
