package com.christian_gonzalez_socialmedia_capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christian_gonzalez_socialmedia_capstone.models.Comment;
import com.christian_gonzalez_socialmedia_capstone.models.Post;
import com.christian_gonzalez_socialmedia_capstone.models.User;
import com.christian_gonzalez_socialmedia_capstone.services.PostService;

@RestController
@RequestMapping(path = "api/post")
public class PostController {
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserController userController;
	
	@GetMapping("/all")
	public List<Post> getPosts() {
		return postService.getAllPosts();
	}
	
	@GetMapping("/all/{name}")
	public List<Post> getUserPost(@PathVariable String name) {
		return postService.getUserPost(name);
	}
	
	@GetMapping("/{id}")
	public Post getPost(@PathVariable Long id) {
		return postService.getPost(id);
	}
	
	// save a post
	@PostMapping("/add")
	public void savePost(@ModelAttribute Post post) {
		Post saving = new Post();
		
		saving.setPostText(post.getPostText());
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		System.out.println(userDetails);
		
		User user = userController.getUser(userDetails.getUsername());
		
		// save user to post
		saving.setUserId(user);
		
		// add attributes to the Post class 'saving'
		saving.setPostText(post.getPostText());
		saving.setTitle(post.getTitle());
		System.out.println(saving);
		
		postService.addPost(saving);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePost(@PathVariable Long id) {
		postService.deletePost(id);
	}
}
