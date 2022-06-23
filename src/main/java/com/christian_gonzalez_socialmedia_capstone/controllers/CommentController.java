package com.christian_gonzalez_socialmedia_capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christian_gonzalez_socialmedia_capstone.models.Comment;
import com.christian_gonzalez_socialmedia_capstone.services.CommentService;

@RestController
@RequestMapping(path = "api/comment")
public class CommentController {
	// to add comments and such...
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/all")
	public List<Comment> getComments(){
		return commentService.getAllComments();
	}
}
