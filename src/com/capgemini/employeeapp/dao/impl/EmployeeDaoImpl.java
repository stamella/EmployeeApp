package com.capgemini.employeeapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.employeeapp.dao.EmployeeDao;
import com.capgemini.employeeapp.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private List<Employee> employees = new ArrayList<>();

	@Override
	public List<Employee> findAllEmployees() {
		return employees;
	}

	@Override
	public Employee findEmployeeById(int employeeId) {
		for (Employee employee : employees) {
			if (employee.getEmployeeId() == employeeId) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "EmployeeDaoImpl [employees=" + employees + "]";
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		for (Employee employee : employees) {
			if (employee.getEmployeeId() == employeeId) {
				employees.remove(employee);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addEmployee(Employee employee) {
//		for (Employee emp : employees) {
//			if (emp.getEmployeeId() == employee.getEmployeeId()) {
//				return false;
//			}
//		}
		return employees.add(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		for (Employee emp : employees) {
			if (emp.getEmployeeId() == employee.getEmployeeId()) {
				emp.setEmployeeName(employee.getEmployeeName());
				emp.setEmployeeSalary(employee.getEmployeeSalary());
				emp.setEmployeeDepartment(employee.getEmployeeDepartment());
			}
			return emp;
		}
		return null;
	}

}