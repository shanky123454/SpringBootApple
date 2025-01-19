package in.com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

@WebListener("/test")
public class DemoContextRequestListener implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context object got deleted");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context object got created");
	}

	static {
		
		System.out.println("listener .class file is loaded");
	}

    
}
