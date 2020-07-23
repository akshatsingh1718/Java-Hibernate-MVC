package com.hcl.dao;

import java.util.List;
import com.hcl.model.Employee;

public interface EmployeeDAO {
	boolean save(Employee e);
	
	boolean delete(int empid);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(int empid);
	
	boolean update(int empid, String newName, String newCity, long newSalary);
}
