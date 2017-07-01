package com.employee.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.employee.model.Employee;

@Entity
@Table(name="DEPARTMENT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SuppressWarnings("serial")
public class Department implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPARTMENTID", nullable = false)
    private int departmentId;
	
	@Size(min=2, max=100)
    @Column(name = "DEPARTMENTNAME", nullable = false)
    private String departmentName;
	
	@OneToMany(mappedBy = "EMPLOYEE", cascade = CascadeType.ALL)
	private List<Employee> employees;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employees="
				+ employees + "]";
	}
}
