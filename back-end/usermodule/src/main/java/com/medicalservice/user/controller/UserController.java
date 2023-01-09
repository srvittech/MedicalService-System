package com.medicalservice.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalservice.user.model.User;
import com.medicalservice.user.service.UserServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	@GetMapping("/getLogin/{id}")
	public User getLogin(@PathVariable Long id) {
		LOGGER.info("Enter into user Controller and getting the method getlogin");
		return userServiceImpl.getLogin(id);
	}
	

	@PostMapping("/addLogin")
	public User addLogin(@RequestBody User user) {
		LOGGER.info("Enter into user Controller and adding the method addlogin");
		return userServiceImpl.addLogin(user);
	}
	@PutMapping("/updateLogin")
	public User updateLogin(@RequestBody User user) {
		LOGGER.info("Enter into user Controller and updating the method updatelogin");
		return userServiceImpl.updateLogin(user);
	}
	}



