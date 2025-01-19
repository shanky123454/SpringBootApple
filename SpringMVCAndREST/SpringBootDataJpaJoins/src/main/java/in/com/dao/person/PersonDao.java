package in.com.dao.person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.com.model.person.Customer;


@Repository
public interface PersonDao extends JpaRepository<Customer,Integer> {
	@Query("select ca.carNo,ca.color,ca.mfgYear,cu.pid,cu.pname,cu.paddress from Customer cu OUTER JOIN MarutiSuzukiCar ca ON cu.pid=ca.carNo")
	public List<Object[]> fetchDataByJoinsByChild();
}
