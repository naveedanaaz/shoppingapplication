package com.productapp.model.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="order_table")
public class Orders {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	private LocalDateTime timestamp;
	private Long storeId;
	
	@JsonIgnore
	@ManyToOne
	private AppUser appUser;
		
	public AppUser getAppUser() {
		return appUser;
	}
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public Orders() {
	}
	public Orders(String name, double price, LocalDateTime timestamp, Long storeId) {
		super();
		this.name = name;
		this.price = price;
		this.timestamp = timestamp;
		this.storeId = storeId;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", name=" + name + ", price=" + price + ", timestamp=" + timestamp + ", storeId="
				+ storeId + "]";
	}
	
}
