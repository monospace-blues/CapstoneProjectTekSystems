package com.christian_gonzalez_socialmedia_capstone.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.christian_gonzalez_socialmedia_capstone.models.Comment;

@SpringBootTest
class CommentServiceTest {

	@Autowired
	CommentService commentService = new CommentService();
	
	Comment testComment = new Comment();
	
	@BeforeEach
	public void setUp() throws Exception {
		// Comment id = 1, userid = 1, postid = 1 
		this.testComment.setPostText("any more?");
		
	}
//	@Test
//	void testGetAllComments() {
//		fail("Not yet implemented");
//	}

	// id is from postId
	@Test
	void testGetCommentsById() {
		List<Comment> commentList = commentService.getCommentsById(1);
		
		assertEquals(testComment.getPostText(), commentList.get(0).getPostText());
	}

}
