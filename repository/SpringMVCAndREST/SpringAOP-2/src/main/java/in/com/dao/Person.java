package in.com.dao;

import java.util.Random;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.SimpleLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



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
	
	
	
//	public void getPerson()
//	{
//		if(new Random().nextInt(17) < 10 )
//		{
//			throw new RuntimeException("Beta thoda dekh ke chalo aage ghada hai");
//		}
//		
//		log.info("person is retrieved");
//	}
	
	public Integer updatePerson()
	{
		logger.trace("person is updated");
		return 5;
		
	}
	
	public String helloPerson(int id,String name)
	{
		logger.info("person is hello");
		return name+" "+id;
	}

}
