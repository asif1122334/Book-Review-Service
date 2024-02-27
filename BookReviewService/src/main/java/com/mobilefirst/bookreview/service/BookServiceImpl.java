package com.mobilefirst.bookreview.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilefirst.bookreview.model.Book;
import com.mobilefirst.bookreview.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	private static final Logger logger = LoggerFactory.getLogger(BookService.class);
	@Autowired
	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getAllBooks() {
		logger.debug("Fetching all book");
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(long id) {

		logger.debug("Fetching book with Id:{} ", id);
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public Book createBook(Book book) {
		logger.debug("Creating a new book");
		return bookRepository.save(book);
	}

	@Override
	public void deleteBookById(long id) {
		logger.debug("Deleting book with ID: {}", id);
		bookRepository.deleteById(id);
		
	}

	@Override
	public Book updateBook(Long id, Book book) {
		logger.debug("Updating book with ID:{}", id);
		Book existingBook = bookRepository.findById(id).orElse(null);

		if (existingBook != null) {
			existingBook.setTitle(book.getTitle());
			existingBook.setAuthor(book.getAuthor());
			existingBook.setPublicationYear(book.getPublicationYear());
			return bookRepository.save(existingBook);
		}
		return null;
	}

}
