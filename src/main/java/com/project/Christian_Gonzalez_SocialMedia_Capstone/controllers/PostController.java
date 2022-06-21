package com.project.Christian_Gonzalez_SocialMedia_Capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Christian_Gonzalez_SocialMedia_Capstone.models.Post;
import com.project.Christian_Gonzalez_SocialMedia_Capstone.services.PostService;

@RestController
@RequestMapping(path = "api/post")
public class PostController {
	@Autowired
	private PostService postService;
	
	@GetMapping("/all")
	public List<Post> getPosts() {
		return postService.getAllPosts();
	}
	
	@GetMapping("/{id}")
	public Post getPost(@PathVariable Long id) {
		System.out.println(id);
		return postService.getPost(id);
	}
}
