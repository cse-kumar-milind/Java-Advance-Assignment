package com.capgemini_java_advance_demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeManagement {
	
	List<Employee> employees = Arrays.asList(
			new Employee(101, "Milind","IT","Developer",90000,6),
			new Employee(102, "Kumar", "IT", "Tester", 70000, 4));
	
	public double averageSalary(List<Employee> employees) {
		
		double avg = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
		
		return avg;
	}
	
	public Employee highestSalary(List<Employee> employees) {
		
		
		return employees.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
		
		
	}
	
	public List<String> getEmployeeMoreThan80K(List<Employee> employees){
		
		return employees.stream().filter(x -> x.getSalary() > 80000).map(Employee::getName).collect(Collectors.toList());
	}
	
	public void numberOfEmployeesPerDepartment(List<Employee> employees) {
		
		Map<String, Long> map = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		
		map.forEach((dept,count) -> System.out.println(dept+" "+count));
	}
	
}
