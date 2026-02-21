package com.javacore.streams;

import java.util.Arrays;
import java.util.List;



public class StreamsPractice {
	
	//filter
	public void evenNumber() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		list.stream().filter(e -> e % 2 == 0).forEach(System.out::println);
	}
	
	public void namesStartingWithA() {
		List<String> names = Arrays.asList("Amit","Ravi","Ankit","Neha");
		
		names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);;

	}
	
	public void numsGreaterThan50() {
		List<Integer> nums = Arrays.asList(10,70,50,20,90,65,35);
		
		nums.stream().filter(n -> n > 50).forEach(System.out::println);
	}
	
	public void nonEmptyStrings() {
		List<String> strings = Arrays.asList("Java","","Python","","C++");
		
		strings.stream().filter(s -> s.length() > 0).forEach(System.out::println);
	}
	
	public void salaryGreaterThan60k() {
		
		List<Employee> employees = Arrays.asList(
				new Employee(101,"Mohit",75000,4),
				new Employee(102,"Rohit",50000,2),
				new Employee(103,"Aman",63000,3));
		
		employees.stream().filter(e -> e.getSalary() > 60000).mapToDouble(Employee::getSalary).forEach(System.out::println);
	}
	
	public void lengthGreaterThan5() {
		
		List<String> words = Arrays.asList("stream","java","filter","code");
		
		words.stream().filter(word -> word.length()>5).forEach(System.out::println);
	}
	
	public void numDivisibleBy3And5() {
		
		List<Integer> list = Arrays.asList(15,20,30,25,45,50);

		list.stream().filter(n -> n % 3 == 0 && n % 5 == 0).forEach(System.out::println);
	}
}
