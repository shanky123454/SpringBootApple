package in.com.project;

import java.util.function.Supplier;

public class DemoForSupplier {
	
	public static void main(String[] args) {
		
		Supplier<String> s1 =()->{
		return	"shashank";
		};
		
		System.out.println(s1.get());
	}

}
