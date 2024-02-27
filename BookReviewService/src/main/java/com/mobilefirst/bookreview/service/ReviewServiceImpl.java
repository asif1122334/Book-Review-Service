package com.mobilefirst.bookreview.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilefirst.bookreview.exception.BookNotFoundException;
import com.mobilefirst.bookreview.model.Book;
import com.mobilefirst.bookreview.model.Review;
import com.mobilefirst.bookreview.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private BookService bookService;

	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		super();
		this.reviewRepository = reviewRepository;
	}

	@Override
	public List<Review> getallReviews() {
		logger.debug("Fetching all reviews");
		return reviewRepository.findAll();
	}

	@Override
	public Review getReviewById(Long id) {
		logger.debug("Fetching review with ID: {}", id);
		return reviewRepository.findById(id).orElse(null);
	}

	@Override
	public Review createReview(Review review) throws BookNotFoundException {
		logger.debug("Creating new review");
		Book book = bookService.getBookById(review.getBook().getId());
		if (book != null) {
			review.setBook(book);
			return reviewRepository.save(review);
		} else {
			throw new BookNotFoundException("Book with ID " + review.getBook().getId() + " not found.");
		}

	}

	@Override
	public Review updateReview(Long id, Review review) {
		logger.debug("Updating review with ID: {}", id);
		Review existingReview = reviewRepository.findById(id).orElse(null);

		if (existingReview != null) {
			existingReview.setRating(review.getRating());
			existingReview.setText(review.getText());

			return reviewRepository.save(existingReview);

		}
		return null;
	}

	@Override
	public void deleteReviewById(Long id) {
		logger.debug("Deleting review with ID: {}", id);
		reviewRepository.deleteById(id);

	}

	@Override
	public List<Review> getReviewsByBookId(long bookId) {
		return reviewRepository.findByBookId(bookId);
	}

}
