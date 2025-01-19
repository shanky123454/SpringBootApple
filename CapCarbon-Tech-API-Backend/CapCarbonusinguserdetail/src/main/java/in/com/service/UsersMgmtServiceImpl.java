package in.com.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.com.dao.IUsersRepo;
import in.com.exception.UserNotFoundException;
import in.com.model.Users;




@Service
public class UsersMgmtServiceImpl implements IUsersMgmtService {

	@Autowired
	private IUsersRepo repo;

	@Override
	public String registerTourist(Users user) {
		Integer tid = repo.save(user).getUserId();
		return "users is registerd having the ticket id :: " + tid;
	}

	@Override
	public List<Users> fetchAllTourist() {
		List<Users> list = repo.findAll();
		list.sort((t1, t2) -> t1.getUserId().compareTo(t2.getUserId()));
		return list;
	}

	@Override
	public Users fetchTouristById(Integer id) {
		/*
		 * Optional<Tourist> optional = repo.findById(id); if (optional.isPresent()) {
		 * return optional.get(); } else { throw new
		 * TouristNotFoundException(" tourist with id "+id+" not found"); }
		 */

		return repo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("users with id :: " + id + " not found"));
	}

	@Override
	public String updateTouristByDetails(Users tourist) {

		Optional<Users> optional = repo.findById(tourist.getUserId());
		if (optional.isPresent()) {
			repo.save(tourist); // save() performs both insert and update depends on id value
			return "Tourist with the id ::" + tourist.getUserId() + " updated";
		} else {
			throw new UserNotFoundException(
					"tourist with the id:: " + tourist.getUserId() + " not available for updation");
		}
	}

	/*
	 * @Override public String updateTouristById(Integer id, Float hikePercent) {
	 * 
	 * Optional<Users> optional = repo.findById(id); if (optional.isPresent()) {
	 * Users tourist = optional.get(); tourist.setBudget(tourist.getBudget() +
	 * (tourist.getBudget() * (hikePercent / 100))); repo.save(tourist); return
	 * "Tourist budget is updated for the id :: " + tourist.getUserId(); } else {
	 * throw new TouristNotFoundException("Tourist not found for the id " + id); }
	 */

//	}

	@Override
	public String deleteTouristById(Integer id) {
		Optional<Users> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.delete(optional.get());
			return "user with the id :: " + id + " deleted...";
		} else {
			throw new UserNotFoundException("user not found for the id " + id);
		}
	}
}
