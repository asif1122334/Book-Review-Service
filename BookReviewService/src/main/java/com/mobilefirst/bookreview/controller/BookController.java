package com.mobilefirst.bookreview.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobilefirst.bookreview.model.Book;
import com.mobilefirst.bookreview.service.BookService;

@RestController
@RequestMapping("/booksApi")
public class BookController {

	@Autowired
	private BookService bookService;

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		logger.info("GET request received to fetch all books.");
		return bookService.getAllBooks();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		logger.info("GET request received to fetch book by ID: {}", id);
		Book bookById = bookService.getBookById(id);

		if (bookById != null) {
			return ResponseEntity.ok(bookById);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/createBook")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		logger.info("POST request received to create book: {}", book);
		Book createBook = bookService.createBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(createBook);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        logger.info("PUT request received to update book with ID {}: {}", id, book);
		Book updatedBook = bookService.updateBook(id, book);
		if (updatedBook != null) {
			return ResponseEntity.ok(updatedBook);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable long id) {
        logger.info("DELETE request received to delete book with ID: {}", id);
		bookService.deleteBookById(id);
		return ResponseEntity.ok("Book with Id " + id + " has been deleted successfully.");
	}

}
