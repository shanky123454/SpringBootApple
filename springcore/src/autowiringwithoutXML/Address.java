package autowiringwithoutXML;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component

public class Address {

    @Value("varthur main road")
	public String road;
	
	@Value("bangalore")
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

