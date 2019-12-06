package com.productapp.web.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.entities.AppUser;
import com.productapp.model.entities.Orders;
import com.productapp.model.entities.Product;
import com.productapp.model.entities.ProductFeatures;
import com.productapp.model.entities.Review;
import com.productapp.model.repo.ProductRepository;
import com.productapp.model.service.OrdersService;
import com.productapp.model.service.ProductFeatureService;
import com.productapp.model.service.ProductService;
import com.productapp.model.service.ReviewService;
import com.productapp.web.controller.beans.PurchaseRequest;
import com.productapp.web.controller.exceptions.ProductNotFoundException;

@RestController
@RequestMapping(path = "api")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductFeatureService productFeatureService;

	@Autowired
	private OrdersService orderService;

	@Autowired
	private ReviewService reviewService;

	@GetMapping(path = "products")
	public List<String> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		List<String> proNames = products.stream().map(product -> product.getName()).collect(Collectors.toList());
		return proNames;
	}
//
//	@GetMapping(path = "products/{productName}")
//	public Product getProductByName(@PathVariable(value = "productName") String productName) {
//		Product product = productService.findProductByName(productName);
//		return product;
//	}

	@GetMapping(path = "products/{productName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductById(@PathVariable(name = "productName") String productName) {
		Product product = productRepository.findByName(productName).orElseThrow(ProductNotFoundException::new);
		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}

	@GetMapping(path = "productFeatures/{productName}")
	public ProductFeatures getProductFeatureByName(@PathVariable(name = "productName") String productName) {
		ProductFeatures product = productFeatureService.findByName(productName);
		return product;

	}

	@PostMapping(path = "/store/product")
	public List<Orders> purchaseOfProductInParticularStore(@AuthenticationPrincipal User user,
			@RequestBody PurchaseRequest request) {
		Product product = productService.findById(request.getProductid());
		List<Orders> orders = orderService.saveOrder(product, user, request.getStoreId());
		return orders;
	}

	@PostMapping(path = "/store/{id}/rating")
	public List<Review> storeReview(@PathVariable(name = "id") Long id, @RequestBody Review review) {
		List<Review> reviews = reviewService.saveReview(review, id);
		return reviews;
	}

}
