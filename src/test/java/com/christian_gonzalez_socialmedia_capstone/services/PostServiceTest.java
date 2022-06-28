package com.christian_gonzalez_socialmedia_capstone.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.christian_gonzalez_socialmedia_capstone.models.Post;

@SpringBootTest
class PostServiceTest {
	
	@Autowired
	PostService postService = new PostService();
	
	Post testPost1 = new Post();
	Post testPost2 = new Post();
	Post testPost3 = new Post();

	@BeforeEach
	public void setUp() throws Exception {
		// id = 6
		this.testPost1.setPostText("Delaware Rivers");
		this.testPost1.setTitle("This isn't good #1");
		// id = 7
		this.testPost2.setPostText("Delaware Rivers");
		this.testPost2.setTitle("This is alright");
		// id = 8
		this.testPost3.setPostText("Delaware Rivers");
		this.testPost3.setTitle("This isn't good");
	}
	
	@Test
	void testGetAllPosts() {
		List<Post> postAllList = postService.getAllPosts();
		
		// compare to one of the posts strings, should match
		assertEquals(testPost3.getTitle(), postAllList.get(7).getTitle());
	}

	@Test
	void testGetUserPost() {
		List<Post> postUserList = postService.getUserPost("amicable");
		
		List<Post> postTestList = new ArrayList<Post>();
		postTestList.add(testPost1);
		postTestList.add(testPost2);
		postTestList.add(testPost3);
		// guessing the list but the object should match the 3 in the db
		assertEquals(postTestList.get(0).getTitle(), postUserList.get(0).getTitle());
		assertEquals(postTestList.get(1).getPostText(), postUserList.get(0).getPostText());
		assertEquals(postTestList.get(2).getPostText(), postUserList.get(2).getPostText());
	}

	@Test
	void testGetPost() {
		Post getPost = postService.getPost(8);
		
		// should match the title
		assertEquals(testPost3.getTitle(), getPost.getTitle());
	}

	// delete doesn't work
//	@Test
//	void testDeletePost() {
//		fail("Not yet implemented");
//	}

}
