package in.com.employee;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Teams {
	
	public Set<String> listTeam;
	public Set<Date> listTeamDate;

	static {
		System.out.println("Employee.static block method()");
	}
	
	public Teams()
	{
		System.out.println("using zero-param constructor");
	}
	
	
	public Set<String> getListTeam() {
		return listTeam;
	}
	public void setListTeam(Set<String> listTeam) {
		this.listTeam = listTeam;
	}
	public Set<Date> getListTeamDate() {
		return listTeamDate;
	}
	public void setListTeamDate(Set<Date> listTeamDate) {
		this.listTeamDate = listTeamDate;
	}

	@Override
	public String toString() {
		return "Teams [listTeam=" + listTeam + ", listTeamDate=" + listTeamDate + "]";
	}
	
}
