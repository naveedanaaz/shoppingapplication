
package com.productapp.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.entities.AppUser;
import com.productapp.model.service.AppUserService;

@RestController
@RequestMapping(path="api")
public class AppUserController {
	@Autowired
	private AppUserService appUserService;
	
	@GetMapping(path="/login",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AppUser>> getAllUsers(){
		return new ResponseEntity<List<AppUser>>(appUserService.getAllUsers(),HttpStatus.OK);
		
	}
	
	@GetMapping(path="/user/{email}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppUser> getAnUser(@PathVariable (name="email")String userEmail){
		return new ResponseEntity<AppUser>(appUserService.findByuserEmail(userEmail),HttpStatus.OK);
		
	}
	
	/*@GetMapping(path="/user/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getAnUser(@PathVariable (name="id")Long id){
		return new ResponseEntity<User>(userService.findUserById(id),HttpStatus.OK);
		
	}*/
	
	@DeleteMapping(path="/user/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteUser(@PathVariable (name="id")Long id){
		appUserService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	
	@PostMapping(path="/user",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppUser> addUser(@Valid @RequestBody AppUser user){
		return new ResponseEntity<AppUser>(appUserService.addUser(user),HttpStatus.CREATED);
		
	}
	
	/*@PutMapping(path="/user/{id}",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@PathVariable (name="id")Long id,@RequestBody User user){
		userService.updateUser(id, user);
		return new ResponseEntity<User>(userService.updateUser(id, user),HttpStatus.OK);
		
	}*/
	

	

}
