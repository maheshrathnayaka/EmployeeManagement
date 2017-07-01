package com.employee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.employee.model.Employee;

public class DataDaoImpl implements DataDao{

	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addEmployee(Employee employee) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public Employee getEmployeeById(int employeeId) throws Exception {
		session = sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class,
				new Integer(employeeId));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return employee;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Employee> employeeList = session.createCriteria(Employee.class).list();
		tx.commit();
		session.close();
		return employeeList;
	}

	@Override
	public boolean deleteEmployee(int employeeId) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Employee.class, employeeId);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
