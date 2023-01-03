package com.medicalservice.user.service;

import java.util.List;
<<<<<<< HEAD

=======
>>>>>>> origin/pavani
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalservice.user.model.User;
import com.medicalservice.user.repository.UserRepository;
import com.medicalservice.user.service.UserServiceImpl;

@Service
public class UserServiceImpl implements Userservice {
	@Autowired
	UserRepository userRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
<<<<<<< HEAD

=======
>>>>>>> origin/pavani
	@Override

	public List<User> getLogin() {
		LOGGER.info("Getting All User From UserService.....");
		return userRepo.findAll();
	}
	
	@Override
	public User addLogin(User user) {
		LOGGER.info("adding All User From UserService.....");
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User updateLogin(User user) {
		
		// TODO Auto-generated method stub
		User userToUpdate = userRepo.findById(user.getId()).orElse(null);
		 if(user.getPassword()!=null) {
			 LOGGER.info("updating password for User From UserService.....");
			 userToUpdate.setPassword(user.getPassword()); 
		 }
		 if(user.getUserName()!=null) {
			 LOGGER.info("updating userName for User From UserService.....");
			 userToUpdate.setUserName(user.getUserName()); 
		 }
		 userRepo.save(userToUpdate);
		 return userToUpdate;

	}

}
