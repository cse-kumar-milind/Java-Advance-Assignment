package com.spring.restapi.controller;
import java.time.LocalDate;
import java.util.List;
import java.util.SortedMap;

import org.hibernate.query.SortDirection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.spring.restapi.model.Book;
import com.spring.restapi.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/author")
	public ResponseEntity<List<Book>> getByAuthor(@RequestParam String author){
		List<Book> books = bookService.getBooksByAuthor(author);
		
		return ResponseEntity.ok(books);
	}
	
	@GetMapping("/genre")
	public ResponseEntity<Page<Book>> getByGenre(@RequestParam String genre, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size){
		
		//Pageable pageable = buildPageable(page, size,"title","asc");
		
		return ResponseEntity.ok(bookService.getBooksByGenre(genre, PageRequest.of(page, size)));
			
	}
	
	@GetMapping("/cheaper")
	public ResponseEntity<List<Book>> getByCheaperThan(@RequestParam Double price){
		
		return ResponseEntity.ok(bookService.getBooksCheaperThan(price));
	}
	
	@GetMapping("/expensive")
	public ResponseEntity<List<Book>> getByExpensiveThan(@RequestParam Double price){
		
		return ResponseEntity.ok(bookService.getBooksExpensiveThan(price));
	}
	
	@GetMapping("/new-arrivals")
	public ResponseEntity<List<Book>> getByPublishAfterDate(@RequestParam LocalDate date){
		
		return ResponseEntity.ok(bookService.getBooksPublishedAfter(date));
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Book>> searchBooksByKeyword(@RequestParam String keyword){
		
		return ResponseEntity.ok(bookService.getBooksWithTitleContaining(keyword));
	}
	
	@GetMapping("/genre-author")
	public ResponseEntity<List<Book>> getByGenreAndAuthor(@RequestParam String genre, @RequestParam String Author){
		
		return ResponseEntity.ok(bookService.getBooksByGenreAndAuthor(genre, Author));
	}
	
	@GetMapping("/genre-or-author")
	public ResponseEntity<List<Book>> getByGenreOrAuthor(@RequestParam String genre, @RequestParam String Author){
		
		return ResponseEntity.ok(bookService.getBooksByGenreOrAuthor(genre, Author));
	}
	
	@GetMapping("/price-range")
	public ResponseEntity<List<Book>> getInPriceRange(@RequestParam(defaultValue = "0") Double minPrice, @RequestParam Double maxPrice){
		
		return ResponseEntity.ok(bookService.getBooksPriceInRange(minPrice, maxPrice));
	}
	
	@GetMapping("/genre-discount")
	public ResponseEntity<List<Book>> getByGenreAndPriceLessThan(@RequestParam String genre, @RequestParam Double price){
		
		return ResponseEntity.ok(bookService.getBooksByGenreAndPriceLessThan(genre, price));
	}
	
	@GetMapping("/latest")
	public ResponseEntity<Page<Book>> getByPublishDateDesc(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "publishedDate") String sortBy, @RequestParam(defaultValue = "desc") String sortDir){
		
		Pageable pageable = buildPageable(page, size, sortBy, sortDir);
		
		return ResponseEntity.ok(bookService.getBooksOrderedByPublishedDateDesc(pageable));
	}
	
	@GetMapping("/by-price")
	public ResponseEntity<Page<Book>> getByPriceAsc(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "price") String sortBy, @RequestParam(defaultValue = "asc") String sortDir){
		
		Pageable pageable = buildPageable(page, size, sortBy, sortDir);
		
		return ResponseEntity.ok(bookService.getBooksOrderedByPrice(pageable));
	} 
	
	@PostMapping()
	public ResponseEntity<String> saveBook(@Valid @RequestBody Book book){
		bookService.saveBook(book);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Saved!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateBook(@PathVariable Long id,@Valid @RequestBody Book book){
		
		bookService.updateBook(id, book);
		
		return ResponseEntity.status(HttpStatus.OK).body("Book details updated!");
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id){
		
		bookService.deleteBookById(id);
	}
	
	private Pageable buildPageable(int page, int size, String sortBy, String sortDir) {
		
		Sort sort = sortDir.equalsIgnoreCase("desc")?
									Sort.by(sortBy).descending() :
									Sort.by(sortBy).ascending();
		
		return PageRequest.of(page, size, sort);
	}
	

}
