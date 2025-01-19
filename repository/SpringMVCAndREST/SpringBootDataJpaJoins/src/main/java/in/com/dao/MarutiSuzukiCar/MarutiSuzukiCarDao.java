package in.com.dao.MarutiSuzukiCar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import in.com.model.MarutiSuzukiCar.MarutiSuzukiCar;

@Repository
public interface MarutiSuzukiCarDao extends JpaRepository<MarutiSuzukiCar,Integer> {

	@Query("select cu.pid,cu.pname,cu.paddress,ca.carNo,ca.color,ca.mfgYear from MarutiSuzukiCar ca inner join ca.person cu")
	public List<Object[]> fetchDataByJoinsByParent();
}
