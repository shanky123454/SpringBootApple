package in.com.DTO;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component(value = "employeeDTO2")
@ConfigurationProperties(prefix  = "emp.info")
public class EmployeeDTO2 implements Serializable {
	static {
		System.out.println("EmployeeDTO2.static()");
	}

	public EmployeeDTO2()
	{
		System.out.println("EmployeeDTO2.EmployeeDTO()");
	}
		private static final long serialVersionUID = 1L;
		
	
		private Integer empNo;
		
	
		private String empName;
		
	
		private Integer deptNo;
		
		
		public Integer getEmpNo() {
			System.out.println("EmployeeDTO.getEmpNo()");
			return empNo;
		}
		public void setEmpNo(Integer empNo) {
			System.out.println("EmployeeDTO2.setEmpNo()");
			this.empNo = empNo;
		}
		public String getEmpName() {
			System.out.println("EmployeeDTO2.getEmpName()");
			return empName;
		}
		public void setEmpName(String empName) {
			System.out.println("EmployeeDTO2.setEmpName()");
			this.empName = empName;
		}
		public Integer getDeptNo() {
			return deptNo;
		}
		public void setDeptNo(Integer deptNo) {
			System.out.println("EmployeeDTO2.setDeptNo()");
			this.deptNo = deptNo;
		}
		@Override
		public String toString() {
			return "EmployeeDTO2 [empNo=" + empNo + ", empName=" + empName + ", deptNo=" + deptNo + "]";
		}
	
	}


