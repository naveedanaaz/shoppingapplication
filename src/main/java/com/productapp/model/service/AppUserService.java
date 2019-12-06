package com.productapp.model.service;

import java.util.*;

import com.productapp.model.entities.AppUser;



public interface AppUserService {
	public AppUser findByuserEmail(String userEmail);

	public AppUser addUser(AppUser user);

	public List<AppUser> getAllUsers();

	// public void blockUser(Long userId);
	public void deleteUser(Long userId);

	public AppUser findUserById(Long userId);
	// public User updateUser(Long userId,User user);

}
