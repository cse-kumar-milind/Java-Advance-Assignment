package com.capgemini.hibernate.task;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class App {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		// 1. CREATE(INSERT)
		
		Book b1 = new Book(101, "Java Basics",
                "James Gosling",
                "Programming",
                450.0,
                "Available",
                2019);

        Book b2 = new Book(102, "Python Mastery",
                "Guido van Rossum",
                "Programming",
                550.0,
                "Available",
                2020);

        Book b3 = new Book(103, "Data Structures",
                "Robert Lafore",
                "Computer Science",
                600.0,
                "Issued",
                2018);
        
        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
        
        System.out.println("Books inserted successfully!");
        
        //2. READ (FETCH BY ID)
        
        Book book = em.find(Book.class, 101);
        
        if(book != null) {
        	System.out.println("\nBook Fetched By ID:");
        	System.out.println(book);
        }
        
        // 3. READ (FETCH ALL)
        
        System.out.println("\nAll Books:");
        
        TypedQuery<Book> query = em.createQuery("select b from Book b", Book.class);
        
        List<Book> list = query.getResultList();
        
        for (Book b : list) {
			System.out.println(b);
		}
        
        // 4. UPDATE
        
        Book updateBook = em.find(Book.class, 102);
        
        if(updateBook != null) {
        	
        	updateBook.setPrice(650.0);
        	updateBook.setAvailabilityStatus("Issued");
        	
        	em.merge(updateBook);
        	
        	System.out.println("\nBook details updated!");
        }
        
        // 5. DELETE
        
        Book deleteBook = em.find(Book.class, 103);
        
        if(deleteBook != null) {
        	
        	em.remove(deleteBook);
        	
        	System.out.println("\nBook Deleted!");
        }
        
        tx.commit();
        
        em.close();
        emf.close();
        
        System.out.println("\nAll Operations connected!");
        
        
        

	}
}
