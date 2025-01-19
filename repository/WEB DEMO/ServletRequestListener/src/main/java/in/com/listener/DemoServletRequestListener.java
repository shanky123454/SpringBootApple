package in.com.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class DemoServletRequestListener implements ServletRequestListener {
	
	static {
		
		System.out.println("listener .class file is loaded");
	}

    public DemoServletRequestListener() {
    	System.out.println("listener class objectis created");  
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("request object is destroyed");
        
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
       System.out.println("request object got created");
    }
    
}
