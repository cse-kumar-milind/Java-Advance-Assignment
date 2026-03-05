package com.spring.restapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.restapi.model.Book;
import java.util.List;
import java.time.LocalDate;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	List<Book> findByAuthor(String author);
	
	Page<Book> findByGenre(String genre, Pageable pageable);
	
	List<Book> findByPriceLessThan(Double price);
	
	List<Book> findByPriceGreaterThan(Double price);
	
	List<Book> findByPublishedDateAfter(LocalDate publishedDate);
	
	List<Book> findByPublishedDateBefore(LocalDate publishedDate);
	
    List<Book> findByTitleContaining(String keyword);
	
	List<Book> findByTitleStartingWith(String prefix);
	
	List<Book> findByTitleEndingWith(String suffix);
	
	List<Book> findByGenreAndAuthor(String genre, String author);
	
	List<Book> findByGenreOrAuthor(String genre, String author);
	
	List<Book> findByPriceBetween(Double minPrice, Double maxPrice);

	List<Book> findByGenreAndPriceLessThan(String genre, Double price);
	
	Page<Book> findByOrderByPublishedDateDesc(Pageable pageable);
	
	Page<Book> findByOrderByPriceAsc(Pageable pageable);
	

}
