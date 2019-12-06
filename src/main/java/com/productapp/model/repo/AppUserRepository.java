package com.productapp.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.model.entities.AppUser;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	  public AppUser findByuserEmail(String email);
	 
}
