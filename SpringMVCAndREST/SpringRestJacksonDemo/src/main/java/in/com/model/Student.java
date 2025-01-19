package in.com.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	public int id;
	public String name;
	public String[] courses;
	public List<String> friendsNames;
	public Set<Integer> phoneNumbers;
	public Map<String,Object> govermentId;
	
	public Address address;
	

}
