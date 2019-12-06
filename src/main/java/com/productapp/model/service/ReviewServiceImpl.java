package com.productapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.entities.Review;
import com.productapp.model.entities.Store;
import com.productapp.model.repo.ReviewRepository;
import com.productapp.model.repo.StoreRepository;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Override
	public List<Review> saveReview(Review review, Long id) {
		Store store=storeRepository.findById(id).orElseThrow(RuntimeException::new);
		store.addReview(review);
		Double review1=((store.getReview()*store.getNoOfReviews())+review.getReview());
		Long number=store.getNoOfReviews()+1l;
		store.setReview(review1/number);
		store.setNoOfReviews(number);
		storeRepository.save(store);
		List<Review> reviews=reviewRepository.findByStoreId(id);
		return reviews;
	}

}
