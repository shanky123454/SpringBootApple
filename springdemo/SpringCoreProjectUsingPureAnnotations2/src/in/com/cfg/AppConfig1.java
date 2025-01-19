package in.com.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = "in/com/commons/application.properties")
public class AppConfig1 {
	
	static {
		System.out.println("AppConfig1.static method()");
	}

	public AppConfig1() {
		System.out.println("AppConfig1.AppConfig1()");
	}
	
	@Autowired
	private Environment env;
	
	@Bean(value = "datasource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dms= new DriverManagerDataSource(); 
		 dms.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		 dms.setUrl(env.getProperty("jdbc.url"));
		 dms.setUsername(env.getProperty("jdbc.username"));
		 dms.setPassword(env.getProperty("jdbc.password"));
		 return (DataSource) dms;
	}

}
