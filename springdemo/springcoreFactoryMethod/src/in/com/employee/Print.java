package in.com.employee;

public class Print {
	
	public static Print instance=null;
	
	static {
		System.out.println("Print.enclosing_method()");
	}
	private Print()
	{
		System.out.println("Print.Print()");
	}
	
	public  static Print getInstance()
	{
		if(instance==null)
		{
			instance= new Print();
			return instance;
		}
		
		return instance;
		
	}

}
