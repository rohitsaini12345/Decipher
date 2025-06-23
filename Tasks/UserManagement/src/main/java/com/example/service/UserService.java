package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.User;

public interface UserService {

	  void registerUser(User user);
	  
	  public Optional<User> findByEmail(String email);
	  
	  public Optional<User> findById(Long id);

	  void updateUser(User user);
	  
	  void deleteUser(Long id);
	  
	  List<User> findAllUsers(); 
}
