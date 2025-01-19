package in.com.runners;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import in.com.SampleTest;

//@Component
//public class CommandLineRunners implements CommandLineRunner {
//
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("arguments are :" + Arrays.asList(args));
//		
//	}
//   }

@Configuration
@Component
public class AppConfig{
	
	@Bean
	public CommandLineRunner runA() {
		
//		return new CommandLineRunner() {
//			
//			@Override
//			public void run(String... args) throws Exception {
//				System.out.println("arguments are :" + Arrays.asList(args));
//			}
//		};
		  
		
//		 return (args)->{
//			System.out.println("arguments are :" + Arrays.asList(args));
//		};
		
		
		return SampleTest::test;
		
		
	}
	


}
