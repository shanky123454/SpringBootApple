package in.com.project;

import java.util.function.BiFunction;
import java.util.function.Function;

public class DemoForFunction {
	
	public static void main(String[] args) {
	
		Function<Integer,Integer> f1 = (i)->i*2;
		
		Function<Integer,Integer> f2 = (i)->i*i*i;
		
		System.out.println(f1.apply(2));//4
		
		System.out.println(f2.apply(2));// 8
		
		System.out.println(f1.andThen(f2).apply(2));// 64
		
		System.out.println(f1.compose(f2).apply(2));// 16
		
		Function<Integer,Integer> f3= Function.identity();
		System.out.println(f3.apply(2)); //2
		
		
		
		BiFunction<Integer, Integer, Integer> bif1 =(x,y)->{
			return x*y; 
		};
		
		Function<Integer, Integer> bif2 =(x)->{
			return x*x; 
		};
		
	System.out.println(bif1.andThen(bif2).apply(2,3));//36
		
		
		
		
		
	}

}
