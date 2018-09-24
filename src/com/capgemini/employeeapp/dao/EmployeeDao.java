package com.capgemini.employeeapp.dao;

import com.capgemini.employeeapp.model.Employee;
import java.util.List;


public interface EmployeeDao {
	public List<Employee> findAllEmployees();
	public Employee findEmployeeById(int employeeId);
	public boolean deleteEmployee(int employeeId);
	public boolean addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	

}
