package in.com.dao;

import java.util.Comparator;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import in.com.DTO.EmployeeDTO;

public interface CustomerDaoInterface {
	
	
	public List<EmployeeDTO> getEmployeesDetailsById(int id1,int id2);
	public  void getEmployeesDetailsById1(int id1);

	

//	public default int findsum(int a,int b)
//	{
//		return a+b;
//	}
//	
	public static int findmul(int a,int b)
	{
		System.out.println();
		return a*b;
		
	}
	
	default int substract(int a,int b)
	{
		return a-b;
		
	}
	
}
