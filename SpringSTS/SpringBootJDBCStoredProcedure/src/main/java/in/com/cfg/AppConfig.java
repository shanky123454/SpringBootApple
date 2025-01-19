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
@PropertySource(value = "./application.properties")
public class AppConfig {
	
	static {
		System.out.println("AppConfig.static method()");
	}

	public AppConfig()
	{
		System.out.println("AppConfig.AppConfig()");
	}
	
	@Autowired
	private Environment env;
	
	@Bean(value = "datasource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dms= new DriverManagerDataSource(); 
		 dms.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		 dms.setUrl(env.getProperty("spring.datasource.url"));
		 dms.setUsername(env.getProperty("spring.datasource.username"));
		 dms.setPassword(env.getProperty("spring.datasource.password"));
		 return dms;
	}
	
//	@Value("${spring.datasource.driver-class-name}")
//	private String DriverClassName;
//	
//	@Value("${spring.datasource.username}")
//	private String Username;
//	
//	@Value("${spring.datasource.password}")
//	private String Password;
//	
//	@Value("${spring.datasource.url}")
//	private String Url;

//	
//	@Bean(value = "datasource")
//	public DataSource getDataSource()
//	{
//		DriverManagerDataSource dms= new DriverManagerDataSource(); 
//		 dms.setDriverClassName(DriverClassName);
//		 dms.setUrl(Url);
//		 dms.setUsername(Username);
//		 dms.setPassword(Password);
//		 return (DataSource) dms;
//	}
	
}
