package com.mobilefirst.bookreview.service;

import java.util.List;
import java.util.Optional;

import com.mobilefirst.bookreview.exception.BookNotFoundException;
import com.mobilefirst.bookreview.model.Review;

public interface ReviewService {

	List<Review> getallReviews();

	Review getReviewById(Long id);

	Review createReview(Review review) throws BookNotFoundException;

	Review updateReview(Long id, Review review);

	void deleteReviewById(Long id);

	List<Review> getReviewsByBookId(long bookId);
}
