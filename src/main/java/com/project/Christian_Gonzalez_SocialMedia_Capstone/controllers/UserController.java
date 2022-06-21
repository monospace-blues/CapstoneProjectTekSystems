package com.project.Christian_Gonzalez_SocialMedia_Capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Christian_Gonzalez_SocialMedia_Capstone.models.User;
import com.project.Christian_Gonzalez_SocialMedia_Capstone.services.UserService;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
//	@Autowired
//	public UserController(UserService userService) {
//		this.userService = userService;
//	}

	@GetMapping
	public List<User> getUser() {
		return userService.getUser();
				
	}
	
	@GetMapping("/all")
	public List<User> getUsers() {
		return userService.getAllUsers();
				
	}
}
