package in.com.DTO;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component(value = "employeeDTO")
@PropertySource(value = "./application.properties")
public class EmployeeDTO implements Serializable {
	static {
		System.out.println("EmployeeDTO.static()");
	}

	public EmployeeDTO()
	{
		System.out.println("EmployeeDTO.EmployeeDTO()");
	}
		private static final long serialVersionUID = 1L;
		
		@Value("${emp.info.empNo}")
		private Integer empNo;
		
		@Value("${emp.info.empName}")
		private String empName;
		
		@Value("${emp.info.deptNo}")
		private Integer deptNo;
		
		
		public Integer getEmpNo() {
			System.out.println("EmployeeDTO.getEmpNo()");
			return empNo;
		}
		public void setEmpNo(Integer empNo) {
			System.out.println("EmployeeDTO.setEmpNo()");
			this.empNo = empNo;
		}
		public String getEmpName() {
			System.out.println("EmployeeDTO.getEmpName()");
			return empName;
		}
		public void setEmpName(String empName) {
			System.out.println("EmployeeDTO.setEmpName()");
			this.empName = empName;
		}
		public Integer getDeptNo() {
			return deptNo;
		}
		public void setDeptNo(Integer deptNo) {
			System.out.println("EmployeeDTO.setDeptNo()");
			this.deptNo = deptNo;
		}
		@Override
		public String toString() {
			return "EmployeeDTO [empNo=" + empNo + ", empName=" + empName + ", deptNo=" + deptNo + "]";
		}
	
	}


