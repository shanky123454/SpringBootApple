package in.com.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.com.bo.CoronaVaccine;

@Repository
public interface CoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

	//@Query( value ="FROM in.com.bo.CoronaVaccine WHERE company=:vendor")
	//	public List<CoronaVaccine> searchVaccinesByCompany(String vendor);
	public List<CoronaVaccine> findVaccinesByCompany(String vendor);

	
	@Modifying
	@javax.transaction.Transactional
	@Query(value ="Insert into coronaaaaa(company,country,name,price,requried_dose_count) values(?,?,?,?,?)",nativeQuery = true)
	public int insertVaccine(String company,String country,String name, Double price,Integer requried_dose_count);

	@Query("From in.com.bo.CoronaVaccine where company in(:company1,:company2)")
	public List<CoronaVaccine> searchVaccinesByCompanies(String company1,String company2);
	
	@Query("Select name from CoronaVaccine WHERE price between :min and :max")
	public List<String> searchVaccinesByPriceRange(double min,double max);
	
	@Query("FROM CoronaVaccine WHERE name in(:name1,:name2)")
	public List<Object[]> searchVaccinesByName(String name1,String name2);
	
	@Transactional
	@Modifying
	@Query("update CoronaVaccine set price=:newPrice where country=:country")
	public int updatePriceByCountry(double newPrice,String country);
	
	@Transactional
	@Modifying
	@Query("delete from in.com.bo.CoronaVaccine where price between :startPrice and :endPrice")
	public int deleteVacinesByPrice(double startPrice,double endPrice);
	
	@Query(value="SELECT NOW() FROM DUAL",nativeQuery = true)
	public Date getSystemDate();



}
