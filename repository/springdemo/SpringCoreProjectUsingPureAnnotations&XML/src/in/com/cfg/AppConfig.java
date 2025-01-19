package in.com.cfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "in.com")
//@PropertySource(value = "in/com/commons/application.properties")
@ImportResource("in/com/cfg/applicationContext.xml")
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
	
//	@Value("${jdbc.driverClassName}")
//	private String DriverClassName;
//	
//	@Value("${jdbc.username}")
//	private String Username;
//	
//	@Value("${jdbc.password}")
//	private String Password;
//	
//	@Value("${jdbc.url}")
//	private String Url;
//
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
