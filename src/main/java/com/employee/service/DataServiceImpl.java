package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.employee.dao.DataDao;
import com.employee.model.Employee;

public class DataServiceImpl implements DataService{

	@Autowired
	DataDao employeeDao;

	@Override
	public boolean addEmployee(Employee employee) throws Exception {
		return employeeDao.addEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(int employeeId) throws Exception {
		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	public List<Employee> getEmployeeList() throws Exception {
		return employeeDao.getEmployeeList();
	}

	@Override
	public boolean deleteEmployee(int employeeId) throws Exception {
		return employeeDao.deleteEmployee(employeeId);
	}
}
