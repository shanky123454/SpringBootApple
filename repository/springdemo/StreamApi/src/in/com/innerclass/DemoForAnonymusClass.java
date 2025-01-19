package in.com.innerclass;

public class DemoForAnonymusClass {
	
	public static void main(String[] args) {
		person p = new person() {
			
			@Override
			void eat() {
			System.out.println("kuuta kha rha hai");
				
			}
		};
		
		p.eat();
	}

}

abstract class person{
	
	abstract void eat();
}
