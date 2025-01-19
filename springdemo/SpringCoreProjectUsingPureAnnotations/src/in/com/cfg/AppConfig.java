package in.com.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "in.com")
@PropertySource(value = "in/com/commons/application.properties")
public class AppConfig {
	
	static {
		System.out.println("AppConfig.static method()");
	}

	public AppConfig()
	{
		System.out.println("AppConfig.AppConfig()");
	}
	
//	@Autowired
//	private Environment env;
//	
//	@Bean(value = "datasource")
//	public DataSource getDataSource()
//	{
//		DriverManagerDataSource dms= new DriverManagerDataSource(); 
//		 dms.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//		 dms.setUrl(env.getProperty("jdbc.url"));
//		 dms.setUsername(env.getProperty("jdbc.username"));
//		 dms.setPassword(env.getProperty("jdbc.password"));
//		 return (DataSource) dms;
//	}
	
	@Value("${cust.driverClassName}")
	private String DriverClassName;
	
	@Value("${cust.username}")
	private String Username;
	
	@Value("${cust.password}")
	private String Password;
	
	@Value("${cust.url}")
	private String Url;

	
	@Bean(value = "datasource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dms= new DriverManagerDataSource(); 
		 dms.setDriverClassName(DriverClassName);
		 dms.setUrl(Url);
		 dms.setUsername(Username);
		 dms.setPassword(Password);
		 return (DataSource) dms;
	}
	
}
