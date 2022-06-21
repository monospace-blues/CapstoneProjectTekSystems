package com.project.Christian_Gonzalez_SocialMedia_Capstone.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Christian_Gonzalez_SocialMedia_Capstone.models.Comment;
import com.project.Christian_Gonzalez_SocialMedia_Capstone.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	// access the db and gets the request
		public List<Comment> getAllComments() {

			List<Comment> comments = new ArrayList<Comment>();
			commentRepository.findAll().forEach(comments::add);
			return comments;
		}
}
