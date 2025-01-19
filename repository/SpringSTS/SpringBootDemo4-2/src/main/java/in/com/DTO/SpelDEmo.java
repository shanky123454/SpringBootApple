package in.com.DTO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "speldemo")
public class SpelDEmo {
	
	static {
		System.out.println("SpelDEmo.static()");
	}

	public SpelDEmo()
	{
		System.out.println("SpelDEmo.SpelDEmo()");
	}
	
@Value("#{employeeDTO2.empNo+employeeDTO2.empName+employeeDTO2.deptNo}") // using SPEL
	public float totalprice;

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	@Override
	public String toString() {
		return "SpelDEmo [totalprice=" + totalprice + "]";
	}
	
}
