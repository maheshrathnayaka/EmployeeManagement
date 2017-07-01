package com.employee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.employee.model.Department;

@Entity
@Table(name = "EMPLOYEE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEEID", nullable = false)
    private int employeeId;
	
	@Size(min=2, max=50)
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;
	
	@Size(min=2, max=50)
    @Column(name = "LASTTNAME", nullable = false)
    private String lastName;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "DEPARTMENTID")
	private Department department;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", department=" + department + "]";
	}

}
