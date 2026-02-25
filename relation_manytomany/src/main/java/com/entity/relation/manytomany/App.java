package com.entity.relation.manytomany;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeProjectManagement");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
//		Project p1 = new Project("Insurance System");
//		Project p2 = new Project("Parking System");
//		
//		Set<Project> projects1 = new HashSet<>();
//		projects1.add(p1);
//		
//		Set<Project> projects2 = new HashSet<>();
//		projects2.add(p1);
//		projects2.add(p2);		
//		
//		
//		Employee e1 = new Employee("John", projects1);
//		Employee e2 = new Employee("Adam", projects2);
//		
//		Set<Employee> employees = new HashSet<>();
//		employees.add(e1);
//		employees.add(e2);
//		
//		p1.setEmployees(employees);
//		p2.setEmployees(employees);
//		
//		em.persist(e1);
//		em.persist(e2);
//		
//		em.getTransaction().commit();
		
		Project project = em.find(Project.class, 1);
		System.out.println(project.getEmployees());
		
		Employee employee = em.find(Employee.class, 2);
		System.out.println(employee.getProjects());
		em.close();
		emf.close();
	}

}
