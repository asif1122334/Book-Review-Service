package com.mobilefirst.bookreview.service;

import java.util.List;

import com.mobilefirst.bookreview.model.Book;

public interface BookService {

	List<Book> getAllBooks();

	Book getBookById(long id);

	Book createBook(Book book);

	Book updateBook(Long id, Book book);

	void deleteBookById(long id);
}
