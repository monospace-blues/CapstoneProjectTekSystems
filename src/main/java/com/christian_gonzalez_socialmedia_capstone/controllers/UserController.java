package com.christian_gonzalez_socialmedia_capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christian_gonzalez_socialmedia_capstone.models.User;
import com.christian_gonzalez_socialmedia_capstone.services.UserService;

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
	public User getUser(String username) {
		return userService.getUser(username);	
	}
	
	@GetMapping("/all")
	public List<User> getUsers() {
		return userService.getAllUsers();
				
	}
}
