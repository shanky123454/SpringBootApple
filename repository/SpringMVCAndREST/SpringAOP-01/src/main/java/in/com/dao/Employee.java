package in.com.dao;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.SimpleLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
public class Employee {
	
	private static final Logger log = LoggerFactory.getLogger(Employee.class);

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Employee.class);

	static {
		
		SimpleLayout layout = new SimpleLayout();
		ConsoleAppender appender = new ConsoleAppender(layout);
		logger.addAppender(appender);
		logger.setLevel(Level.ALL);
	}
	
	
	
	public void getEmployee()
	{
		log.info("Employee is retrieved");
	}
	
	public void insertEmployee()
	{
		logger.fatal("employee is inserted");
	}

}
