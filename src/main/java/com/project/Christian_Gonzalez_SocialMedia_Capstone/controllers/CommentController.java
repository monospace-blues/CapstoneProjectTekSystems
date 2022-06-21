package com.project.Christian_Gonzalez_SocialMedia_Capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Christian_Gonzalez_SocialMedia_Capstone.models.Comment;
import com.project.Christian_Gonzalez_SocialMedia_Capstone.services.CommentService;

@RestController
@RequestMapping(path = "api/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/all")
	public List<Comment> getComments(){
		return commentService.getAllComments();
	}
}
