package com.usermanagement.restapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usermanagement.restapi.exception.UserNotFoundException;
import com.usermanagement.restapi.model.User;
import com.usermanagement.restapi.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
	
	public void updateUser(long id, User updated) {
		if(!userRepository.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		
		User existingUser = getUserById(id);
		
		existingUser.setFullName(updated.getFullName());
		existingUser.setEmail(updated.getEmail());
		existingUser.setPassword(updated.getPassword());
		existingUser.setRole(updated.getRole());
		existingUser.setAge(updated.getAge());
		
		userRepository.save(existingUser);
	}
	
	public void deleteUser(long id) {
		if(!userRepository.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		userRepository.deleteById(id);
	}
	
}
