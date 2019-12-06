package com.productapp.model.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "user_table")
public class AppUser {
	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "user_Name")
	private String userName;

	@NotEmpty(message = "Email should not be Empty ")
	@Column(name = "user_Email")
	private String userEmail;

	@Column(name = "user_Password")
	private String userPassword;

	@Column(name = "user_Address")
	private String userAddress;

	@Column(name = "user_PhoneNo")
	private String userPhoneNo;

	private String[] roles;

	@OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Orders> orders = new ArrayList<Orders>();

	public void addMyOrders(Orders order) {
		orders.add(order);
		order.setAppUser(this);
	}

	public static BCryptPasswordEncoder getEncoder() {
		return encoder;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public static void setEncoder(BCryptPasswordEncoder encoder) {
		AppUser.encoder = encoder;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		// this.userPassword=userPassword;
		this.userPassword = encoder.encode(userPassword);
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;

	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public AppUser(String userName, String userEmail, String userPassword, String userAddress, String userPhoneNo,
			String[] roles) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		// this.userPassword=userPassword;
		setUserPassword(userPassword);
		this.userAddress = userAddress;
		this.userPhoneNo = userPhoneNo;
		this.roles = roles;

	}

	public AppUser() {

	}

	@Override
	public String toString() {
		return "AppUser [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userAddress=" + userAddress + ", userPhoneNo=" + userPhoneNo + ", roles="
				+ Arrays.toString(roles) + "]";
	}

}
