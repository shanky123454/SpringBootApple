package in.com.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.com.dto.Voter;

@Component(value = "service")
public class service {

	static {
		System.out.println("service.static method()");
	}

	public service() {
	System.out.println("service.service()");
	}
	
	@Autowired
	public Voter voter;
	
	@PostConstruct
	public void myInit() {
		System.out.println("Voter.myInit()");
		System.out.println(this);
//		voter.dov = new Date();
		boolean flag = false;

		if (voter.vname == null) {
			System.out.println("Name must not be null");
			flag = true;
		}
		if (voter.vage < 0)
			voter.vage = voter.vage * -1;

		if (voter.vage > 100) {
			System.out.println("Age must not be > 100");
			flag = true;
		}
		if (flag)
			throw new IllegalArgumentException("Invalid inputs...");

	}
	
	// Businesss logic
	public String checkVotingEligibility() {
		System.out.println("Voter.checkVotingEligibility()");
		System.out.println(this);

		if (voter.vage >= 18)
			return "Mr/Miss/Mrs: " + voter.vname + " " + voter.vid  + " u r eligibile for voting: " + voter.vage + " ---> on " + voter.dov;
		else
			return "Mr/Miss/Mrs: " + voter.vname + " " + voter.vid  + " u r not eligibile for voting: " + voter.vage + "---> on " + voter.dov;

	}

	@PreDestroy
	public void myDestroy() {
		System.out.println("Voter.myDestroy()");
		// nullify the bean properties
		voter.vname = null;
		voter.vage = 0;
		voter.dov = null;
		voter.vid=0;
		System.out.println(voter);
	}

	@Override
	public String toString() {
		return "service [voter=" + voter + "]";
	}

	
}
