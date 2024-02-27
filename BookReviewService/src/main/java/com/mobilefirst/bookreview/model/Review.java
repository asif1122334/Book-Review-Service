package com.mobilefirst.bookreview.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int rating;
	
	private String text;
	
	@ManyToOne
	private Book book;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Review(long id, int rating, String text, Book book) {
		super();
		this.id = id;
		this.rating = rating;
		this.text = text;
		this.book = book;
	}

	public Review() {
		super();
 	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", text=" + text + ", book=" + book + "]";
	}
	
	
}
