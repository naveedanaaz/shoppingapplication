package com.productapp.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.entities.Product;
import com.productapp.model.repo.ProductRepository;
import com.productapp.web.controller.exceptions.ProductNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {

		return (List<Product>) productRepository.findAll();
	}

	

	@Override
	public Product findById(Long productid) {
		// TODO Auto-generated method stub
		return productRepository.findById(productid).orElseThrow(RuntimeException::new);
	}



	@Override
	public Product findProductByName(String productName) {
		//Product product = productRepository.findByName(productName).o;
		return productRepository.findByName(productName).orElseThrow(ProductNotFoundException::new);
	}

}