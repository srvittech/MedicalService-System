package com.medicalservice.user.service;

import java.util.List;

import com.medicalservice.user.model.User;

public interface Userservice {
	public List<User> getLogin();
	public User addLogin(User user);
	public User updateLogin(User user);
	
      
}
