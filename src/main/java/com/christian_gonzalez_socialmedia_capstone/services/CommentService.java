package com.christian_gonzalez_socialmedia_capstone.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christian_gonzalez_socialmedia_capstone.models.Comment;
import com.christian_gonzalez_socialmedia_capstone.repository.CommentRepository;

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
	
	public List<Comment> getCommentsById(long id) {
		List<Comment> comments = getAllComments();
		
		List<Comment> commentsById = new ArrayList<Comment>();
		
		for (Comment x : comments) {
			if (x.getPostId().getId() == id) {
				commentsById.add(x);
			}
		}
		
		return commentsById;
	}
	
	public void addComment(Comment comment) {
		commentRepository.save(comment);
	}
}
