package in.com.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

@WebListener("/test")
public class Demolistener implements ServletRequestListener {
	
	 public int hitcount =0;

	static {
		System.out.println("listener .class is loaded");
	}
	
    public Demolistener() {
        System.out.println("listener object got created");
    }

	
    public void requestDestroyed(ServletRequestEvent sre)  { 
       System.out.println("request object got destroyed");
    }

	
    public void requestInitialized(ServletRequestEvent sre)  { 
        System.out.println("request object got created");
        hitcount++;
        System.out.println("total hit count is" + hitcount);

        

    }
	
}
