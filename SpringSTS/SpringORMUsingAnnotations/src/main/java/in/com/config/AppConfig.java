package in.com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;

import in.com.BO.StudentBO;

@Configuration
@PropertySource(value = "in/com/commons/application.properties")
@ComponentScan(basePackages = "in.com")
@EnableTransactionManagement
public class AppConfig {
	
	@Autowired
	public org.springframework.core.env.Environment env;
	
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource dms= new DriverManagerDataSource(); 
		 dms.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		 dms.setUrl(env.getProperty("spring.datasource.url"));
		 dms.setUsername(env.getProperty("spring.datasource.username"));
		 dms.setPassword(env.getProperty("spring.datasource.password"));
		 return dms;
	}
	
	@Bean
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setHibernateProperties(getHibernateProperties());
		bean.setDataSource(getDataSource());
		bean.setAnnotatedClasses(StudentBO.class);
		try {
			bean.afterPropertiesSet();
			} catch (Exception e) {
			  e.printStackTrace();
			}
		return bean.getObject();
	}
	
	@Bean
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		return properties;
	}
	
	@Bean
	public HibernateTemplate getHibernateTemplate()
	{
			HibernateTemplate hibernateTemplate = new HibernateTemplate(getSessionFactory());
			return hibernateTemplate;
	}
	
	 @Bean
	  public HibernateTransactionManager hibTransMan() {
		return new HibernateTransactionManager(getSessionFactory());
	  }
	
}
