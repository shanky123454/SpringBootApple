package in.com;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.com.service.CoronaVaccineImplClass;

@SpringBootApplication
public class SpringBootSpringDataJpaProjectApplication {

	public static void main(String[] args) {
	ApplicationContext applicationContext =	SpringApplication.run(SpringBootSpringDataJpaProjectApplication.class, args);
CoronaVaccineImplClass class1 =	applicationContext.getBean(CoronaVaccineImplClass.class);
  class1.fetchVaccinesByCompany("poonawala").forEach(System.out::println);
//   int result = class1.registerVaccine("bajaj", "IND", "bajajVaxin",49.33, 2);
//   System.out.println(result);
//   class1.fetchVaccinesByCompanies("adani", "ambani").forEach(System.out::println);
//   class1.fetchVaccinesByPriceRange(20.0,25.00).forEach(System.out::println);
// List<Object[]> obj =  class1.fetchVaccinesByName("cowin","covaxin");
// 			for (Object[] objects : obj) {
//				for (Object objects2 : objects) {
//					System.out.println(objects2);
//				}
//				System.out.println();
//			}
 			
// int rowupdated=class1.modifyingPriceByCountry(78.99, "IND");
// System.out.println(rowupdated);
// 
// int rowupdated1=class1.removeVacinesByPrice(30.00,50.44);
// System.out.println(rowupdated1);
// 
//	Date date = class1.fetchSystemDate();
//	System.out.println(date);

	}
	

}
