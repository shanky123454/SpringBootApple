package in.com.conf;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "in.com")
//@PropertySource(value = "./application.properties")
@ConfigurationProperties(value = "spring.datasource")
public class ApplicationConfiguration {
	@Autowired
	public Environment environment;
	

	@Bean(value = "dataSource")
	@Profile(value = {"test"})
	public DataSource getDataSource()
	{
	
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
		dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dataSource.setPassword(environment.getProperty("spring.datasource.password"));
		return dataSource;
	}
}
