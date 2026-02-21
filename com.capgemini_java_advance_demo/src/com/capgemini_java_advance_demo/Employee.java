package com.capgemini_java_advance_demo;

public class Employee {
	private int employeeId;
	private String name;
	private String department;
	private String designation;
	private double salary;
	private int yearOfExperience;
	
	
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String name, String department, String designation, double salary,
			int yearOfExperience) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
		this.yearOfExperience = yearOfExperience;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(Integer yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", department=" + department + ", designation="
				+ designation + ", salary=" + salary + ", yearOfExperience=" + yearOfExperience + "]";
	}
	
	
	
}
