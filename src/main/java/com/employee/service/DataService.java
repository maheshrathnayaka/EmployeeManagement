package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface DataService {
	
	public boolean addEmployee(Employee employee) throws Exception;

	public Employee getEmployeeById(int employeeId) throws Exception;

	public List<Employee> getEmployeeList() throws Exception;

	public boolean deleteEmployee(int employeeId) throws Exception;
	
}
