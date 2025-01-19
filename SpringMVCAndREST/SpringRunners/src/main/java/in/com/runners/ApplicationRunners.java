package in.com.runners;



import java.util.Arrays;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunners implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("NON-option args are :" + args.getNonOptionArgs());
		System.out.println("option args names are :" + args.getOptionNames());
		System.out.println("source args are:" + Arrays.asList(args.getSourceArgs()));

	Set<String> set = args.getOptionNames();
	for (String string : set) {
		System.out.println( string +":"+args.getOptionValues(string));
	}

	}

}
