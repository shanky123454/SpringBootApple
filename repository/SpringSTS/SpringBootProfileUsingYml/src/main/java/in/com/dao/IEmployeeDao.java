package in.com.dao;

import java.util.List;

import in.com.BO.EmployeeBO;


public interface IEmployeeDao {

	public List<EmployeeBO>  getEmpByDesg(String cond);
}
