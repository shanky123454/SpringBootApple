package in.com.project;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

@FunctionalInterface
interface demo{
	void print(String msg);
}

public class TestClass {
	
	public void display(String msg) {
		msg= msg.toUpperCase();
		System.out.println(msg);
	}
	
	public static int addition(int a ,int b) {
		return a+b;
	}

	public static void main(String[] args)
	{
//		List<Employee> listemp = new ArrayList<>();
//		
//		listemp.add(new Employee(9345, "shashank"));
//		listemp.add(new Employee(6754, "shanky"));
//		listemp.add(new Employee(9999, "paglu"));
//		
//	List<Employee> e11 =	listemp.stream().sorted((e1,e2)-> {
//		return	e2.getSalary()- e1.getSalary();
//		}).collect(Collectors.toList());
//	System.out.println(e11);
//		
//   List<Employee> employees1 =	listemp.stream()
//       .sorted((e1,e2)-> e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
//
//System.out.println(employees1);
//
//Optional<Employee> employees2 =	listemp.stream().min((o1,o2)
//		-> o1.getName().compareTo(o2.getName())
//		);
//
//System.out.println(employees2);
//
//		List<Employee> employees = listemp.stream()
//				.sorted(Comparator.comparingInt((Employee)-> Employee.getSalary()))
//				.collect(Collectors.toList());
//		
//		System.out.println(employees);
//		
//	List<Employee> employees3 =	listemp.stream().sorted(new Comparator<Employee>() {
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//		}).collect(Collectors.toList());
//	System.out.println(employees3);
//
//	
//	List<Integer> employees4= listemp.stream().map((Employee)-> Employee.getSalary() + 50000)
//	.collect(Collectors.toList());
//	System.out.println(employees4);
//	
//	
//  List<Employee> employees5 =	listemp.stream()
//    .sorted(Comparator.comparingInt((Employee)->((in.com.project.Employee) Employee).getSalary()).reversed())
//       .collect(Collectors.toList());
//
//      System.out.println(employees5);
//      
//  List<Employee> employees6 =    listemp.stream().sorted(Comparator.comparing((Employee) -> 
//      ((in.com.project.Employee) Employee).getName())).collect(Collectors.toList());
//  
//  System.out.println(employees6);
//  
//  List<Employee> employees7 =    listemp.stream().sorted(Comparator.comparing((Employee) -> 
//  ((in.com.project.Employee) Employee).getName()).reversed()).collect(Collectors.toList());
//
//System.out.println(employees7);
//
//                       Optional<Employee> optional = listemp.stream().findAny();
//                       optional.stream().forEach(System.out::println);
//                       
//                       Optional<Employee> optional1 = listemp.stream().findFirst();
//                       optional1.stream().forEach(System.out::println);
//                       
//                   Long l =  listemp.stream().count();
//            System.out.println(l);
		
		BiFunction<Integer, Integer, Integer> biFunctiones = (a,b)->(a+b);
		System.out.println(biFunctiones.apply(2, 5));
		System.out.println(biFunctiones.andThen((a)->a*a).apply(2, 5));
		
		BiPredicate<Integer, Integer> biPredicate = (x,y) -> x>y;
		BiPredicate<Integer, Integer> biPredicate1 = (x,y) -> x==y;
	

		Boolean boolean1 = biPredicate.and(biPredicate1).test(20, 10);
		System.out.println(boolean1);
		
		Boolean boolean2  = biPredicate.or(biPredicate1).test(20, 10);
		System.out.println(boolean2);
		
		biPredicate= biPredicate.negate();
		System.out.println(biPredicate.test(10, 20));
		
		 Predicate<Double> predicate = (x)-> x>10;
		 Predicate<Double> predicate2 = Predicate.not(predicate);
		 System.out.println(predicate2.test(5.0));
		 
		  Predicate<String> predicate1 = Predicate.isEqual("shashank raj");
		  System.out.println(predicate1.test("shashank raj singh"));
		
		  
		String[] strArray = {"a","b","c"};
		Stream<String> streamuu = Arrays.stream(strArray);
		streamuu.forEach(System.out::println);
		
		List<String> ls = Arrays.asList("java","dbms","co","cn");
		Stream<String> ss =  ls.stream();
		ss.forEach((msg)->System.out.println(msg));
		
		// How to create immutable collections(List,Set,HashMap)
		List<String> loot = List.of("shanky", "Shashank");
		//loot.add("ritu");
		System.out.println(loot);
		
		Map<String,String> map = new HashMap<>();
		map.put("1", "SHASHANK");
//	   map =Collections.unmodifiableMap(map);
		map.put("5", "oyrrr");
		System.out.println(map);
		
		Map<String,String> map1 = Map.ofEntries(Map.entry("1", "ERRR"),Map.entry("2" ,"fgggg"));
		//map1.put("3", "null");
		System.out.println(map1);
		// ********************************************************
		
	Stream<Integer> sturum = Stream.of(1,55,2,34,87,0);
	Optional<Integer> min=	sturum.min(Comparator.comparingInt(Integer::valueOf));
	System.out.println(min.get());
	
	Stream<Integer> sturum1 = Stream.of(1,55,2,34,87,0);
	Optional<Integer> max=	sturum1.max(Comparator.comparingInt(Integer::valueOf));
	System.out.println(max.get());

		//  METHOD REFERENCE DEMO
		
		TestClass testClass = new TestClass();
	    demo ademo = (msg)-> testClass.display(msg);
		ademo.print("good morning");
		
		BiFunction<Integer, Integer, Integer> biFunction = (a,b)->TestClass.addition(a, b);
		System.out.println(biFunction.apply(2, 3));
		
		BiFunction<Integer, Integer, Integer> biFunction1 = TestClass::addition;// method reference for static methods
		System.out.println(biFunction.apply(2, 3));
		System.out.println(biFunction.andThen(a->a*10).apply(10,20));
		
		BiConsumer<Integer, Integer> biConsumer = (a,b)-> System.out.println(a+b);
		  biConsumer.accept(10, 20);
		  
		  BiConsumer<Integer, Integer> biConsumer1 = (a,b)-> System.out.println(a+b);
		  biConsumer1.andThen((x,y)->{
			  System.out.println(x*10);
			  System.out.println(y*10);
			  }).accept(10, 20);
		  
		  
		  Consumer<Integer> consumer = (a)->System.out.println(a);
		  consumer.andThen((a)->{
                      System.out.println(a+10);
		  }).accept(100);
		 
		
		Function<Integer, Double> function = (a)->Math.sqrt(a);
		System.out.println(function.apply(2));
		
		Function<Integer, Double> function11 = (a)->Math.sqrt(a);
		System.out.println(function11.apply(2));
		System.out.println(function11.andThen((a)->(a+100)).apply(81));
		
		Function<Integer, Double> function111 = (aa)->Math.sqrt(aa);
		System.out.println(function111.apply(2));
		function111=function111.compose((a) -> a*10);
		System.out.println(function111.andThen((a)->(a+10.0)).apply(2));
	
		
		Function<Integer, Double> function1 = Math::sqrt;// method reference for static methods ==>> classname::its static method
		System.out.println(function.apply(2));
		
		TestClass class1 = new TestClass();
		demo demo = (a)->  class1.display(a);
		demo.print("good moarning");
		
		
		TestClass class2 = new TestClass();
		demo demo1 = class2::display; // method reference for object ==>> // Object::its instance method
		demo1.print("good maorning");
		
		 Function<String, String> function2 = (String input)->input.toLowerCase();
		 System.out.println(function2.apply("JAVA"));
		 
		 Function<String, String> function3 = String::toLowerCase;// classname::its instance method
		 System.out.println(function3.apply("JAVA"));
		 
		 Integer[] arary = {44,12,55,16};  
		 Arrays.sort(arary, (a,b)-> a.compareTo(b)); 
		 for (Integer integer : arary) {
			System.out.println(integer);
		}
		 
		 Integer[] arary1 = {4,1,5,6};
		 Arrays.sort(arary1, Integer::compareTo);
		 for (Integer integer : arary1) {
				System.out.println(integer);
			}
		
		 
		 Stream<Integer> stream = Stream.of(1,2,3,4,5);
		 
		Integer[]  aa =stream.toArray((a)-> new Integer[a]);
		 for (Integer integer : aa) {
			System.out.println(integer);
		}
		  
		 Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
		 Integer[] integers = stream1.toArray(Integer[]::new);// Reference to a constructor ==>> classname::new
		for (Integer integer : integers) {
			System.out.println(integer);
		}
		
		List<String> list  = new ArrayList<>();
		list.add("SHANKY");
		list.add("ritu");
		list.add("sundram");
		
		Function<List<String>, HashSet<String>> function4 = (a) -> new HashSet<>(a);
		System.out.println(function4.apply(list));
		
		Function<List<String>, HashSet<String>> function5 = HashSet::new;// Reference to a constructor ==>> classname::new
		System.out.println(function5.apply(list));
		System.out.println(function5.apply(list).getClass().getName());
		
		
		
	// *******************************************************************
		
		Employee e1 = new Employee(22, "shanky");
		Employee e2 = new Employee(22,"shanky");
		
		
		System.out.println(e1.equals(e2));
		System.out.println(e1==e2);
	}

}
