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
		return userRepo.findAll();
	}

	@Override
	public User addLogin(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User updateLogin(User user) {
		// TODO Auto-generated method stub
		User userToUpdate = userRepo.findById(user.getId()).orElse(null);
		 if(user.getPassword()!=null) {
			 userToUpdate.setPassword(user.getPassword()); 
		 }
		 if(user.getUserName()!=null) {
			 userToUpdate.setUserName(user.getUserName()); 
		 }
		 return userRepo.save(userToUpdate);

	}

}
