package com.mobilefirst.bookreview.controller;

import java.util.List;
import java.util.Optional;

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

import com.mobilefirst.bookreview.exception.BookNotFoundException;
import com.mobilefirst.bookreview.model.Review;
import com.mobilefirst.bookreview.service.ReviewService;

@RestController
@RequestMapping("/reviews/api")
public class ReviewCntroller {

	@Autowired
	public ReviewService reviewService;

	private static final Logger logger = LoggerFactory.getLogger(ReviewCntroller.class);

	@GetMapping("/AllReviews")
	public List<Review> getallReviews() {
		logger.info("GET request received to fetch all reviews.");
		return reviewService.getallReviews();
	}

	@GetMapping("/books/{bookId}")
	public ResponseEntity<List<Review>> getReviewsByBookId(@PathVariable long bookId) {
		logger.info("GET request received to fetch reviews by ID: {}", bookId);
		List<Review> reviews = reviewService.getReviewsByBookId(bookId);
		if (!reviews.isEmpty()) {
			return ResponseEntity.ok(reviews);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Review> getReviewById(@PathVariable long id) {
		logger.info("GET request received to Get review By ID: {}", id);
		Review reviewById = reviewService.getReviewById(id);
		if (reviewById != null) {
			return ResponseEntity.ok(reviewById);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/createReview")
	public ResponseEntity<Review> createReview(@RequestBody Review review) throws BookNotFoundException {
		logger.info("POST request received to create review: {}", review);
		Review createReviews = reviewService.createReview(review);
		return ResponseEntity.status(HttpStatus.CREATED).body(createReviews);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Review> updateReviews(@PathVariable long id, @RequestBody Review review) {
		logger.info("PUT request received to update review with ID {}: {}", id, review);
		Review updateReview = reviewService.updateReview(id, review);
		if (updateReview != null) {
			return ResponseEntity.ok(updateReview);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteReviewById(@PathVariable long id) {
		logger.info("DELETE request received to delete review By ID: {}", id);
		reviewService.deleteReviewById(id);
		return ResponseEntity.ok("Review with id:" + id + " has been deleted successfully");
	}

}
