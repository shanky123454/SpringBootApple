package in.com.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "in.com")
@PropertySource(value = "in/com/commons/application.properties")
//@ImportResource(value = "in/com/cfg/applicationContext.xml")
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
	
	@Value("${jdbc.driverClassName}")
	
	
	private String DriverClassName;
	
	@Value("${jdbc.username}")
	private String Username;
	
	@Value("${jdbc.password}")
	private String Password;
	
	@Value("${jdbc.url}")
	private String Url;
 
	
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
	
	@Bean(value="datasource")
	public HikariDataSource getHikariDataSource() {
		HikariDataSource hds = new HikariDataSource();
		hds.setDriverClassName(DriverClassName);
		hds.setJdbcUrl(Url);
		hds.setUsername(Username);
		hds.setPassword(Password);
		hds.setMinimumIdle(10);
		hds.setMaximumPoolSize(10);
		hds.setConnectionTimeout(2000);
		return hds;
	}
	
}
