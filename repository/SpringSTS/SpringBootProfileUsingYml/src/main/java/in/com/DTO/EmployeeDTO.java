package in.com.DTO;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component(value = "employeeDTO")
public class EmployeeDTO implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private Integer srNo;
		private Integer empNo;
		private String empName;
		private String job;
		private Double sal;
		private Integer deptNo;
		private Integer mgrNo;

		@Override
		public String toString() {
			return "EmployeeDTO [srNo=" + srNo + ", empNo=" + empNo + ", empName=" + empName + ", job=" + job + ", sal="
					+ sal + ", deptNo=" + deptNo + ", mgrNo=" + mgrNo + "]";
		}

		public Integer getEmpNo() {
			return empNo;
		}

		public void setEmpNo(Integer empNo) {
			this.empNo = empNo;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public String getJob() {
			return job;
		}

		public void setJob(String job) {
			this.job = job;
		}

		public Double getSal() {
			return sal;
		}

		public void setSal(Double sal) {
			this.sal = sal;
		}

		public Integer getDeptNo() {
			return deptNo;
		}

		public void setDeptNo(Integer deptNo) {
			this.deptNo = deptNo;
		}

		public Integer getMgrNo() {
			return mgrNo;
		}

		public void setMgrNo(Integer mgrNo) {
			this.mgrNo = mgrNo;
		}

		public Integer getSrNo() {
			return srNo;
		}

		public void setSrNo(Integer srNo) {
			this.srNo = srNo;
		}


	}


