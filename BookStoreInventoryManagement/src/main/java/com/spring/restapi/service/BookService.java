package com.spring.restapi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.restapi.exception.BookNotFoundException;
import com.spring.restapi.model.Book;
import com.spring.restapi.repository.BookRepository;


@Service
public class BookService {
	
	private BookRepository bookRepository;
	
	

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> getBooksByAuthor(String author){
		
		List<Book> books = bookRepository.findByAuthor(author);
		
		if(books.isEmpty()) {
			throw new BookNotFoundException("Book not found with author: "+author);
		}
		
		return books;
	}
	
	public Page<Book> getBooksByGenre(String genre, Pageable pageable){
		Page<Book> books = bookRepository.findByGenre(genre, pageable);
		
		if(books.isEmpty()) {
			throw new BookNotFoundException("Book not found with genre: "+genre);
		}
		
		return books;
		
	}
	
	public List<Book> getBooksCheaperThan(Double price){
		
		List<Book> books = bookRepository.findByPriceLessThan(price);
		
		if(books.isEmpty()) {
			throw new BookNotFoundException("No books found!");
		}
		
		return books;
	}
	
	public List<Book> getBooksExpensiveThan(Double price){
		
		List<Book> books = bookRepository.findByPriceGreaterThan(price);
		
		if(books.isEmpty()) {
			throw new BookNotFoundException("No books found!");
		}
		
		return books;
	}
	
	public List<Book> getBooksPublishedAfter(LocalDate date){
		
		List<Book> books = bookRepository.findByPublishedDateAfter(date);
		
		if(books.isEmpty()) {
			throw new BookNotFoundException("No books found!");
		}
		
		return books;
		
	}
	
	public List<Book> getBooksWithTitleContaining(String keyword){
		
		List<Book> books = bookRepository.findByTitleContaining(keyword);
		
		if(books.isEmpty()) {
			throw new BookNotFoundException("No books found!");
		}
		
		return books;
	}
	
	public List<Book> getBooksByGenreAndAuthor(String genre, String author){
		
		List<Book> books = bookRepository.findByGenreAndAuthor(genre, author);
		
		if(books.isEmpty()) {
			throw new BookNotFoundException("No books found!");
		}
		
		return books;
	}
	
	public List<Book> getBooksByGenreOrAuthor(String genre, String author){
		
		List<Book> books = bookRepository.findByGenreOrAuthor(genre, author);
		
		if(books.isEmpty()) {
			throw new BookNotFoundException("No books found!");
		}
		
		return books;
	}

	public List<Book> getBooksPriceInRange(Double minPrice, Double maxPrice){
		
		List<Book> books = bookRepository.findByPriceBetween(minPrice, maxPrice);
		
		if(books.isEmpty()) {
			throw new BookNotFoundException("No books found!");
		}
		
		return books;
	}
	
	public List<Book> getBooksByGenreAndPriceLessThan(String genre, Double price){
		
		List<Book> books = bookRepository.findByGenreAndPriceLessThan(genre, price);
		
		if(books.isEmpty()) {
			throw new BookNotFoundException("No books found!");
		}
		
		return books;
	}
	
	public Page<Book> getBooksOrderedByPublishedDateDesc(Pageable pageable){
		
		Page<Book> books = bookRepository.findByOrderByPublishedDateDesc(pageable);
		
		if(books.isEmpty()) {
			throw new BookNotFoundException("No books found!");
		}
		
		return books;
	}
	
	public Page<Book> getBooksOrderedByPrice(Pageable pageable){
		
		Page<Book> books = bookRepository.findByOrderByPriceAsc(pageable);
		
		if(books.isEmpty()) {
			throw new BookNotFoundException("No books found!");
		}
		
		return books;
	}
	
	public void saveBook(Book book) {
		bookRepository.save(book);
	}
	
	public Book getBookById(Long id) {
		
		return bookRepository.findById(id).orElseThrow(
				() -> new BookNotFoundException("Book not found with id: "+id));
	}
	
	public void updateBook(Long id, Book updatedBook) {
		
		Book existingBook = getBookById(id);
		
		existingBook.setAuthor(updatedBook.getAuthor());
		existingBook.setGenre(updatedBook.getGenre());
		existingBook.setPrice(updatedBook.getPrice());
		existingBook.setPublishedDate(updatedBook.getPublishedDate());
		existingBook.setTitle(updatedBook.getTitle());
		
		bookRepository.save(existingBook);
		
	}
	
	public void deleteBookById(Long id) {
		getBookById(id);
		
		bookRepository.deleteById(id);
	}
	
	
	
	
}
