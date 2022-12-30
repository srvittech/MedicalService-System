package com.medicalservice.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicalservice.user.model.User;
import com.medicalservice.user.service.UserServiceImpl;

@RestController
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;

	@GetMapping("/getLogin")
	public List<User> getLogin() {
		return userServiceImpl.getLogin();
	}
	@PostMapping("/addLogin")
	public User addLogin(@RequestBody User user) {
		return userServiceImpl.addLogin(user);
	}
	@PutMapping("/updateLogin/{id}")
	public User updateLogin(@RequestBody User user) {
		return userServiceImpl.updateLogin(user);
	}
	}


