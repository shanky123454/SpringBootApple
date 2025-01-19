package in.com.innerclass;

public class DemoForAnonymusClass3 {
	
	public static void main(String[] args) {
	
		// Anonymus inner class by extending a class(here thread class)
		Thread t= new Thread() {
			
			@Override
			public void run() {
			System.out.println("child thread");
			}
		};
		
		t.start();
		
//*************************************************************************
		
		
// Anonymus inner class by implemeting a interface(here Runnable interface)

		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("child thread");
			}
		};
		
		Thread t1 = new Thread(r);
		t1.start();
		
//*****************************************************************************
	
		// Anonymous Inner class that defines inside method/constructor argument
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
			
				System.out.println("child thread");
				
			}
		});
		
		t3.start();
	}
	
}
