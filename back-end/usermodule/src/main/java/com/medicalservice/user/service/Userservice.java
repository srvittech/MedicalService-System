package com.medicalservice.user.service;

import java.util.List;

import com.medicalservice.user.model.User;

public interface Userservice {
	public User getLogin(Long id);
	public User addLogin(User user);
	public User updateLogin(User user);
	
      
}
