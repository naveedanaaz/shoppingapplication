package com.productapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="review_table")
public class Review {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private double review;
	private String comment;
	@JsonIgnore
	@JoinColumn(name="storeid_fk")
	@ManyToOne
	private Store store;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getReview() {
		return review;
	}
	public void setReview(double review) {
		this.review = review;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	
	
	public Review(double review, String comment) {
		
		this.review = review;
		this.comment = comment;
	}
	public Review() {
	}
	@Override
	public String toString() {
		return "Reviews [id=" + id + ", review=" + review + ", comment="
				+ comment + "]";
	}
	
	
	
	

}
