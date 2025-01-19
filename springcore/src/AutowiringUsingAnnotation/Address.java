package AutowiringUsingAnnotation;

public class Address {

	public String road;
	public String city;
	
	public String getRoad() {
		return road;
	}
	@Override
	public String toString() {
		return "Address [road=" + road + ", city=" + city + "]";
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}


