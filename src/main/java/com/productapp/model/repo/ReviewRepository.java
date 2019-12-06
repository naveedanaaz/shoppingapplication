package com.productapp.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.model.entities.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
public List<Review> findByStoreId(Long id);
}
