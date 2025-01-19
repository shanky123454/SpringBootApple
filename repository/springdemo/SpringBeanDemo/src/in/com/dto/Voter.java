package in.com.dto;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "in/com/commons/application.properties")
public class Voter {
	
	static {
		System.out.println("Voter.static method()");
	}

	public Voter() {
         System.out.println("Voter.Voter()");
         System.out.println(this);
	}
   
	@Value("${voter.id}")
	public int vid;
	
	@Value("${voter.name}")
	public String vname;
	
	@Autowired
	public LocalDate dov;
	
	@Value("${voter.age}")
	public int vage;

	@Override
	public String toString() {
		return "Voter [vid=" + vid + ", vname=" + vname + ", dov=" + dov + ", vage=" + vage + "]";
	}
	
}
