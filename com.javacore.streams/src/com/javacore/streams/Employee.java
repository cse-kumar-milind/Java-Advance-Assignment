package com.javacore.streams;

public class Employee {
	private int employeeId;
	private String name;
	private double salary;
	private int yearOfExperience;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int employeeId, String name, double salary, int yearOfExperience) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.yearOfExperience = yearOfExperience;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getYearOfExperience() {
		return yearOfExperience;
	}
	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", yearOfExperience="
				+ yearOfExperience + "]";
	}
	
	
}
