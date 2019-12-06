package com.productapp.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productapp.model.entities.ProductFeatures;

public interface ProductFeatureRepository extends
		JpaRepository<ProductFeatures, Long> {

	/*Product findByName(String name);*/
	
	//public Product findByName(String name);
	
	public ProductFeatures findByName(String name);
	

}
