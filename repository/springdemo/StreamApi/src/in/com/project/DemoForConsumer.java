package in.com.project;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class DemoForConsumer {

	public static void main(String[] args) {
		
		Consumer<Integer> c1 = (i)-> {
			System.out.println(i);
		};
		
		Consumer<Integer> c2 = (i)-> {
			System.out.println(i);
		};
		
		c1.accept(2); //2
		c2.accept(3); //3
		
		c1.andThen(c2).accept(3); //3 3
		
		BiConsumer<String, String> bic1 =(x,y)->{
			System.out.println(x.length());
		};
		
		//bic1.accept("dog", "cat");
		
		BiConsumer<String, String> bic2 =(x,y)->{
			System.out.println(y.length());
		};
		
		//bic2.accept("dog", "cats");
		
		bic1.andThen(bic2).accept("dogs", "cat");

		
		
		
	}
}
