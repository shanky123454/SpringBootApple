package in.com.stockprice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.com.dao.StockDaoRepo;
import in.com.model.StockInfo;
import in.com.stockprice.Exception.StockNotFoundException;

@Service
public class StockPriceImpl implements IStockPriceService {
	
	@Autowired
	public StockDaoRepo daoRepo;

	@Override
	public Double findByCompanyId(Integer companyId) {
	Optional<StockInfo> optional =	daoRepo.findById(companyId);
		if(optional.isEmpty()) 
		{
			throw new StockNotFoundException("Company not available");
		}
		else return  optional.get().getPrice(); 
	}

}
