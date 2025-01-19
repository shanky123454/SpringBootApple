package in.com.employee;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Movie {
	
	public Map<Integer,String> listMovies;
	public Map<String,Date> listMoviesDate;

	static {
		System.out.println("Employee.static block method()");
	}
	
	public Movie()
	{
		System.out.println("using zero-param constructor");
	}

	public Map<Integer, String> getListMovies() {
		return listMovies;
	}

	public void setListMovies(Map<Integer, String> listMovies) {
		this.listMovies = listMovies;
	}

	public Map<String, Date> getListMoviesDate() {
		return listMoviesDate;
	}

	public void setListMoviesDate(Map<String, Date> listMoviesDate) {
		this.listMoviesDate = listMoviesDate;
	}

	@Override
	public String toString() {
		return "Movie [listMovies=" + listMovies + ", listMoviesDate=" + listMoviesDate + "]";
	}

	
}
