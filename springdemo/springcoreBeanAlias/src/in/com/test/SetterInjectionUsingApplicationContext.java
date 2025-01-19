package in.com.test;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.com.employee.Employee;
import in.com.employee.student;


public class SetterInjectionUsingApplicationContext {

	public static void main(String[] args) {
		
		//ClassPathResource fres = new ClassPathResource("in\\com\\cfg\\applicationContext.xml"); // ERROR
       ApplicationContext factory = new ClassPathXmlApplicationContext("in\\com\\cfg\\applicationContext.xml");
       
		Object obj =factory.getBean("CS",Employee.class);
		Employee e = (Employee)obj;
		System.out.println(e);
		
		Object obj1 =factory.getBean("Std1",student.class);
		student s = (student)obj1;
		System.out.println(s);
		
	ArrayList<String> al = new ArrayList<>();
	HashMap<Integer, String> hm = new HashMap<>();
	hm.entrySet();
	LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
	TreeMap<Integer, String> tm = new TreeMap<>();
	
	LinkedList<String> l = new LinkedList<>();
	
	HashSet< String> hs = new HashSet<>();
	LinkedHashSet<String> lhs = new LinkedHashSet<>();
	TreeSet<Integer> i = new TreeSet<>();
	
	PriorityQueue< String> pq = new PriorityQueue<>();
	
	ArrayDeque< Float> ad = new ArrayDeque<>();
	
	Properties p = new Properties();

	}

}
