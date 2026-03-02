package com.usermanagement.restapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.restapi.model.User;
import com.usermanagement.restapi.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping()
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping()
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
		userService.saveUser(user);
		
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id,@Valid @RequestBody User user){
		
		userService.updateUser(id, user);
		
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
	}
	
	
	
	
}
