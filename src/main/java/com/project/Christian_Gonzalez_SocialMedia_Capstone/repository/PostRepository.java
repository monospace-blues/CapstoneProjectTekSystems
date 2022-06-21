package com.project.Christian_Gonzalez_SocialMedia_Capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Christian_Gonzalez_SocialMedia_Capstone.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	// needed to link this abstract class to the variables in the Post model (in this case, id)
	Post findPostById(Long id);
}
