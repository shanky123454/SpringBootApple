package in.com.project;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoForPredicate {

	public static void main(String[] args) {
		Employee employee1 = new Employee(2345, "SHANKY");
		Employee employee2 = new Employee(2345, "ritu");
		Employee employee3 = new Employee(2345, "mucchar");

		List<Employee> list1 = List.of(employee1, employee2, employee3);
		System.out.println(list1);

		Employee employee4 = new Employee(2345, "chacha");
		Employee employee5 = new Employee(2345, "marwadi");
		Employee employee6 = new Employee(2345, "baba");
 
		List<Employee> list2 = List.of(employee4, employee5, employee6);

		System.out.println(list2);

		List<List<Employee>> lists = List.of(list1, list2);

		List<Employee> list = lists.stream().flatMap(t -> t.stream()).collect(Collectors.toList());

		System.out.println(list);

		List<String> list3 = lists.stream().flatMap(t -> t.stream()).map(t -> t.getName()).collect(Collectors.toList());

		System.out.println(list3);

		List<String> list4 = List.of("A", "B", "C", "1", "2", "3");

		list4.stream().reduce((x, y) -> {
			return x + y;
		});

		List<String> res = list4.stream().sorted((x, y) -> {
			return y.compareTo(x);
		}).collect(Collectors.toList());
		System.out.println(res);

		Optional<String> optional = list4.stream().reduce((x, y) -> {
			return x + y;
		});
		System.out.println(optional.get());

		
		  List<Integer> list5 = List.of(2,1,6,3);
		  
	List<Integer> list11 =  list5.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
	System.out.println(list11);	  
	
	
	List<Integer> listt2 =  list5.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	System.out.println(listt2);	  
	
	
		List<Integer> res1=  list5.stream().sorted((x,y)->{
			  return Integer.compare(y, x);
		  }).collect(Collectors.toList());
		 System.out.println(res1);
	
	
		 //  DEMO FOR PREDICATE
	Predicate<Integer> p1 = (i)-> {
		return i%2==0;
	};
	
	Predicate<Integer> p2 = (i)-> {
		return i>50;
	};
	
	Predicate<Integer> predi;
	
	System.out.println(p1.test(22));
	System.out.println(p2.test(23));
	
	
    predi =	p1.and(p2);
	System.out.println(predi.test(89));
	

    predi =	p1.or(p2);
	System.out.println(predi.test(23));
	
	predi = p1.negate();
	System.out.println(predi.test(22));
	
	
	Predicate<String> str =  Predicate.isEqual("shanky");
		
	Predicate<String> str1 =  Predicate.not((x)->{
		return x.length()>3;
	});
	
	System.out.println(str1.test("shanky"));
	
	System.out.println(str.test("shanky"));
	
	// DEMO FOR BIPREDICATE
	
	BiPredicate<Integer, Integer> bip1 = (x,y)->{
		return x>y;
	};
	System.out.println(bip1.test(5,6));
	
	BiPredicate<Integer, Integer> bip2 = (x,y)->{
		return x%y==0;
	};
	
	System.out.println(bip1.test(5,6));
	
	BiPredicate<Integer, Integer> bip3 =bip1.and(bip2);
	System.out.println(bip3.test(10,7));
	
	BiPredicate<Integer, Integer> bip4 =bip1.or(bip2);
	System.out.println(bip4.test(10,4));
	
	BiPredicate<Integer, Integer> bip5 =bip1.negate();
	System.out.println(bip5.test(1,4));
	
	System.out.println("*************************************************");

	
	Employee e1= new Employee(2334, "shahsank");
	Employee e2 = new Employee(56675, "ritu");
	Employee e3 = new Employee(56675, "ritu");
	
	System.out.println(e1.hashCode());
	System.out.println(e2.hashCode());
	System.out.println(e3.hashCode());
	
	System.out.println(e1.equals(e2));
	System.out.println(e2.equals(e3));

	System.out.println("*************************************************");
	
	String s1= "shashank";
	String s2 ="shashank";
	
	System.out.println(s1.hashCode());
	System.out.println(s2.hashCode());
	
	System.out.println(s1.equals(s2));
	
	System.out.println("++++++++++++++++++++++++++++++++++++++++++");
	
	Integer a = 5;
	@SuppressWarnings("deprecation")
	Integer b = new Integer(5);
	Integer c= 5;
	System.out.println(a==(b));//false
	System.out.println(a.equals(b));//true	
	System.out.println(a==c);//true

	
	
}	
	
	
}
