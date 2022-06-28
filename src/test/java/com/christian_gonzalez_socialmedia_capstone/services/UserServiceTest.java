package com.christian_gonzalez_socialmedia_capstone.services;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.christian_gonzalez_socialmedia_capstone.models.User;

@SpringBootTest
class UserServiceTest {
	
	@Autowired
	UserService userService = new UserService();;
	
	User testUser = new User();	
	
	@BeforeEach
	public void setUp() throws Exception {

		 this.testUser.setUsername("amicable");
	}

	@Test
	void testGetUser() {
		
		User user = userService.getUser(testUser.getUsername());
		
		assertEquals("amicable", user.getUsername());
	}

}
