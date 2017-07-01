package com.employee.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.model.Employee;
import com.employee.model.Status;
import com.employee.service.DataService;

@Controller
@RequestMapping("/employee")
public class RestController {

	static final Logger logger = Logger.getLogger(RestController.class);

	@Autowired
	DataService employeeService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addEmployee(@RequestBody Employee employee) {
		try {
			employeeService.addEmployee(employee);
			return new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("employeeId") int employeeId) {
		Employee employee = null;
		try {
			employee = employeeService.getEmployeeById(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getEmployee() {
		List<Employee> employeeList = null;
		try {
			employeeList = employeeService.getEmployeeList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Status deleteEmployee(@PathVariable("employeeId") int employeeId) {
		try {
			employeeService.deleteEmployee(employeeId);
			return new Status(1, "Employee deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}
}
