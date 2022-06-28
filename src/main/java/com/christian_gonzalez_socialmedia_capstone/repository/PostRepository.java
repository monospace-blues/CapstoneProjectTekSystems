package com.christian_gonzalez_socialmedia_capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.christian_gonzalez_socialmedia_capstone.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	// needed to link this abstract class to the variables in the Post model (in this case, id)
	Post findPostById(Long id);
	
}
