package com.entity.relation.manytoone.task;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("customerManagement");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Customer customer = new Customer("Milind","milind@gmail.com");
		
		em.persist(customer);
		
		Orders order1 = new Orders("05-Jan-2026", 599.99, customer);
		Orders order2 = new Orders("26-Jan-2026", 1399.99, customer);
		Orders order3 = new Orders("07-Feb-2026", 399.99, customer);
		Orders order4 = new Orders("09-Feb-2026", 999.99, customer);
		
		em.persist(order1);
		em.persist(order2);
		em.persist(order3);
		em.persist(order4);
		
		System.out.println("Orders and Customer saved!\n");
		
		Orders order = em.find(Orders.class, 3);
		
		System.out.println(order.getCustomer());
		
		System.out.println("\nCustomer displayed!");
		
		em.getTransaction().commit();
		
		
		
		
		
		
	}

}
