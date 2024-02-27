package com.mobilefirst.bookreview.exception;

public class BookNotFoundException extends Exception {
public String message;

public BookNotFoundException(String message) {
	super();
	this.message = message;
}

}
