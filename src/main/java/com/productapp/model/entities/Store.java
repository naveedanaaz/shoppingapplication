package com.productapp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "store_table")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String email;
	private String phone;
	private Double review;
	private Long noOfReviews;

	@JsonIgnore
	@JoinTable(name = "product_store_jt", joinColumns = @JoinColumn(name = "productid_fk"), inverseJoinColumns = @JoinColumn(name = "storeid_fk"))
	@ManyToMany
	private List<Product> products = new ArrayList<>();
	// @JsonIgnore
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Review> reviews = new ArrayList<>();

	public void addReview(Review review) {
		reviews.add(review);
		review.setStore(this);
	}

	public Double getReview() {
		return review;
	}

	public void setReview(Double review) {
		this.review = review;
	}

	public Long getNoOfReviews() {
		return noOfReviews;
	}

	public void setNoOfReviews(Long noOfReviews) {
		this.noOfReviews = noOfReviews;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Store(String name, String address, String email, String phone, Double review, Long noOfReviews) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.review = review;
		this.noOfReviews = noOfReviews;
	}

	public Store() {
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", phone=" + phone
				+ ", review=" + review + ", noOfReviews=" + noOfReviews + "]";
	}

}
