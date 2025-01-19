package in.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import in.com.model.StockInfo;
import java.util.Optional;



public interface StockDaoRepo extends JpaRepository<StockInfo,Integer> {

	public  Optional<StockInfo> findById(Integer id);
	
}
