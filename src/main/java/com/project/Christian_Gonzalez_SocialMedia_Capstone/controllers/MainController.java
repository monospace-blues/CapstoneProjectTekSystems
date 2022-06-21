package com.project.Christian_Gonzalez_SocialMedia_Capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.Christian_Gonzalez_SocialMedia_Capstone.models.Post;

@Controller
public class MainController {
	
	@Autowired
	PostController postController;
	
	@GetMapping("/")
	public String allPosts(Model model) {
		
		List<Post> ResultSet = postController.getPosts();
		
		model.addAttribute("postList", ResultSet);
		
		return "index";
	}
	
	@GetMapping("posts")
	public String post(Model model) {
		Post single = postController.getPost((long) 1);
		
		return "posts.html";
	}
	
	@RequestMapping("about")
	@ResponseBody
	public String about() {
		return "about.html";
	}
}
