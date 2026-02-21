package com.entity.relation.manytoone.task;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookManagement");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Publisher publisher = new Publisher(1l,"Notion","Delhi");
		
		em.persist(publisher);
		
		Book b1 = new Book(1l,"Explore Java", 398.99, publisher);
		Book b2 = new Book(2l,"How To Groww", 459.99, publisher);
		Book b3 = new Book(3l,"Don't Become Perfect", 299.99, publisher);
		
		List<Book> books = Arrays.asList(b1,b2,b3);
		
		publisher.setBooks(books);
		
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		
		Publisher findPublisher = em.find(Publisher.class, 1);
		
		System.out.println(findPublisher.getBooks());
		
		System.out.println("\nPublisher's books displayed!!\n");
		
		Book findBook = em.find(Book.class, 2);
		
		System.out.println(findBook.getPublisher());
		System.out.println("\nBook's publisher displayed!\n");
		
		tx.commit();
		
		System.out.println("\nBooks and Publisher saved!\n");
		
		
		
	}

}
