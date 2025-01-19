package in.com;

import org.springframework.jdbc.core.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import in.com.Impl.Student;

@SpringBootApplication
public class SpringDemo3Application {

	public static void main(String[] args) {
	ApplicationContext applicationContext =	SpringApplication.run(SpringDemo3Application.class, args);
	
	Student s = applicationContext.getBean("std",Student.class);
	String result =s.getDetails();
	System.out.println(result);
	
	BeanPropertyRowMapper<Student> beanPropertyRowMapper = new BeanPropertyRowMapper<Student>(Student.class);
	ResultSetExtractor< Student> extractor = new ResultSetExtractor<Student>() {
		
		@Override
		public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			return null;
		}
	};
	}
	
}
