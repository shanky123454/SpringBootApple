package in.com.VO;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component(value = "employeeVO")
public class EmployeeVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String srNo;
	private String empNo;
	private String empName;
	private String sal;
	private String deptNo;
	private String mgrNo;

	@Override
	public String toString() {
		return "EmployeeVO [srNo=" + srNo + ", empNo=" + empNo + ", empName=" + empName + ", sal=" + sal + ", deptNo="
				+ deptNo + ", mgrNo=" + mgrNo + "]";
	}

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getMgrNo() {
		return mgrNo;
	}

	public void setMgrNo(String mgrNo) {
		this.mgrNo = mgrNo;
	}
        
	}


