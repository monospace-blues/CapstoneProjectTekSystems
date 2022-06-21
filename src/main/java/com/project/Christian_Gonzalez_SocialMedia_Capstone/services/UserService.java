package com.project.Christian_Gonzalez_SocialMedia_Capstone.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.Christian_Gonzalez_SocialMedia_Capstone.models.User;
import com.project.Christian_Gonzalez_SocialMedia_Capstone.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	// static variable instead from the db, will do that later
	public List<User> getUser() {
		return List.of(
				new User(1, "helvetica", "password", LocalDate.of(2001, 05, 28))
				);
				
	}

	// access the db and gets the request
	public List<User> getAllUsers() {

	       List<User> users = new ArrayList<User>();
	       userRepository.findAll().forEach(users::add);
	       return users;
	}

}
