package in.com.dao.MarutiSuzukiCar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.com.model.MarutiSuzukiCar.MarutiSuzukiCar;

@Repository
public interface MarutiSuzukiCarDao extends JpaRepository<MarutiSuzukiCar,Integer> {

}
