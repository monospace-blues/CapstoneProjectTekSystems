package com.christian_gonzalez_socialmedia_capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;


import com.christian_gonzalez_socialmedia_capstone.models.Post;


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
	
	@GetMapping("/posts/{id}")
	public String posts(Model model, @PathVariable("id") String id) {
		long pathId = Long.parseLong(id);
		// Post single = postController.getPost(pathId);
		
		// model.addAttribute(id)
		return "posts";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}

	// login
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}
