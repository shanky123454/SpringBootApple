package in.com.innerclass;

public class DemoForAnonymusClass2 {
	
	public static void main(String[] args) {
		personn p = new personn() {
			
			public void eat() {
			System.out.println("kuuta kha rha hai");
				
			}
		};
		
		p.eat();
	}

}

class personn{
	
	public void eat() {
		System.out.println("person is eating");
	}
}
