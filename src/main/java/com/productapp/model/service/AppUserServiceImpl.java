package com.productapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.model.entities.AppUser;
import com.productapp.model.repo.AppUserRepository;


@Service
@Transactional
public class AppUserServiceImpl implements AppUserService{

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Override
	public AppUser findByuserEmail(String userEmail) {
		// TODO Auto-generated method stub
		return appUserRepository.findByuserEmail(userEmail);
	}

	@Override
	public List<AppUser> getAllUsers() {
		// TODO Auto-generated method stub
		return appUserRepository.findAll();
	}

	@Override
	public AppUser addUser(AppUser user) {
		// TODO Auto-generated method stub
		return appUserRepository.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		appUserRepository.deleteById(userId);		
	}

	@Override
	public AppUser findUserById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
