package com.productapp.model.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.entities.Product;
import com.productapp.model.entities.ProductFeatures;
import com.productapp.model.repo.ProductFeatureRepository;

@Service
@Transactional
public class ProductFeatureServiceImpl implements ProductFeatureService {
	@Autowired
	private ProductFeatureRepository productfeatureRepository;

	@Override
	public ProductFeatures findByName(String name) {
		
		return productfeatureRepository.findByName(name);
	}

	
	
}
