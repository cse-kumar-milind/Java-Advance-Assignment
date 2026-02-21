package com.entity.relation.manytoone;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("universityManagement");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Department department = new Department("Computer Science");
		
		em.persist(department);
		
		Student s1 = new  Student("Rahul", department);
		Student s2 = new  Student("Aman", department);
		Student s3 = new  Student("Rohit", department);
		
		List<Student> students = Arrays.asList(s1,s2,s3);
		
		department.setStudents(students);
		
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		
		em.getTransaction().commit();
		
		System.out.println("Students and Department Saved!");
		
		
	}
}
