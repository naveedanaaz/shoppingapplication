package com.productapp.model.service;

import java.util.List;

import com.productapp.model.entities.Review;

public interface ReviewService {
	public List<Review> saveReview(Review review, Long id);
}
