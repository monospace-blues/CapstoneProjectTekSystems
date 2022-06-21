package com.project.Christian_Gonzalez_SocialMedia_Capstone.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Christian_Gonzalez_SocialMedia_Capstone.models.Post;
import com.project.Christian_Gonzalez_SocialMedia_Capstone.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	// access the db and gets the request
	public List<Post> getAllPosts() {

		List<Post> posts = new ArrayList<Post>();
		postRepository.findAll().forEach(posts::add);
		return posts;
	}
	
	public Post getPost(Long id) {
		Post single = postRepository.findPostById(id);
		return single;
	}
}
