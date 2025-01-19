package in.com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.com.bo.CoronaVaccine;
import in.com.dao.CoronaVaccineRepo;

@Service("service")
public class CoronaVaccineImplClass implements CoronaVaccineInterface {

	@Autowired
	public CoronaVaccineRepo coronaVaccineRepo;
	
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByCompany(String company) {
	return  coronaVaccineRepo.findVaccinesByCompany(company);

		
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCompanies(String comp1, String comp2) {
		return coronaVaccineRepo.searchVaccinesByCompanies(comp1, comp2);
	}

	@Override
	public List<String> fetchVaccinesByPriceRange(double min, double max) {
		return coronaVaccineRepo.searchVaccinesByPriceRange(min, max);
	}

	@Override
	public List<Object[]> fetchVaccinesByName(String name1, String name2) {
		return coronaVaccineRepo.searchVaccinesByName(name1, name2);
	}

	@Override
	public int modifyingPriceByCountry(double newPrice, String country) {
		return coronaVaccineRepo.updatePriceByCountry(newPrice, country);
	}

	@Override
	public int removeVacinesByPrice(double startPrice, double endPrice) {
		return coronaVaccineRepo.deleteVacinesByPrice(startPrice, endPrice);
	}

	@Override
	public int registerVaccine(String company, String country, String name, Double price, Integer required_dose_count) {
	return coronaVaccineRepo.insertVaccine(company, country, name, price, required_dose_count);

	}

	@Override
	public Date fetchSystemDate() {
		return coronaVaccineRepo.getSystemDate();
	}

}
