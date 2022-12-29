package com.medicalservice.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalservice.user.model.User;
import com.medicalservice.user.service.UserServiceImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@RestController
@EnableSwagger2
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;

	
	@GetMapping("/getLogin")
	public List<User> getLogin() {
		return userServiceImpl.getLogin();
	}

}
