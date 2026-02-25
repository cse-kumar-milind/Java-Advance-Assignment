package com.entity.relation.onetoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Account account = new Account("ACC12345", "Savings");
		Customer customer = new Customer("John Doe", account);
		
		account.setCustomer(customer);
		
		em.persist(customer);
		
		em.getTransaction().commit();
		
		System.out.println("Customer and Account saved!");
	}
}
