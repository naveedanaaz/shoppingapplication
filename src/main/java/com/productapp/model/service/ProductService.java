package com.productapp.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.Link;

import com.productapp.model.entities.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public Product findProductByName(String productName);
	
	public Product findById(Long productid);
 


}
