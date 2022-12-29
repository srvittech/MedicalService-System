package com.medicalservice.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalservice.user.model.User;
import com.medicalservice.user.repository.UserRepository;
@Service
public class UserServiceImpl implements Userservice {
	@Autowired
	UserRepository userRepo;
	@Override
	
	public List<User> getLogin() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	

}
