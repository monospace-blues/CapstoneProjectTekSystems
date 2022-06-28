package com.christian_gonzalez_socialmedia_capstone.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christian_gonzalez_socialmedia_capstone.models.Comment;
import com.christian_gonzalez_socialmedia_capstone.models.Post;
import com.christian_gonzalez_socialmedia_capstone.models.User;
import com.christian_gonzalez_socialmedia_capstone.services.CommentService;

@RestController
@RequestMapping(path = "api/comment")
public class CommentController {
	// to add comments and such...
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PostController postController;
	
	@Autowired UserController userController;
	
	// testing purposes
	@GetMapping("/all")
	public List<Comment> getComments(){
		return commentService.getAllComments();
	}
	
	// get comments for the single posts...
	@GetMapping("/{id}")
	public List<Comment> getComment(@PathVariable Long id) {
		return commentService.getCommentsById(id);
	}
	
//	// save comment
//	@PostMapping("/savecomment")
//	public void saveComment(@ModelAttribute Comment comment) {
//		Comment saving = comment;
//		
//		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		
//		System.out.println(userDetails);
//		
//		User user = userController.getUser(userDetails.getUsername());
//		
//		saving.setUserId(user);
//		
//		Post post = postController.getPost(comment.getPostId().getId());
//		
//		System.out.println(post);
//		saving.setPostId(post);
//		System.out.println(saving);
//		commentService.addComment(saving);
//		
//	}
	
	@PostMapping("/savecomment/{id}")
	public void saveComment(@ModelAttribute Comment comment, @PathVariable long id) {
		Comment saving = new Comment();
		
		saving.setPostText(comment.getPostText());
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		System.out.println(userDetails);
		
		User user = userController.getUser(userDetails.getUsername());
		
		saving.setUserId(user);
		
		Post post = postController.getPost(id);
		
		System.out.println(post);
		saving.setPostId(post);
		System.out.println(saving);
		
		commentService.addComment(saving);
	}
}
