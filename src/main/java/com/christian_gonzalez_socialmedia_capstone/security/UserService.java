package com.christian_gonzalez_socialmedia_capstone.security;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.christian_gonzalez_socialmedia_capstone.models.User;

public interface UserService extends UserDetailsService {
	   User findByUsername(String username);
	   User save(UserRegistrationDto registration);
	}