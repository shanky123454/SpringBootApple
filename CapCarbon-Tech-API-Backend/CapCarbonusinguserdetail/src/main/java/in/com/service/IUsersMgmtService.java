package in.com.service;

import java.util.List;

import in.com.model.Users;

public interface IUsersMgmtService {
	public String registerTourist(Users tourist);
	public List<Users> fetchAllTourist();
	public Users fetchTouristById(Integer id);
	public String updateTouristByDetails(Users tourist);
	//public String updateTouristById(Integer id,Float hikePercent);
	public String deleteTouristById(Integer id);
}
