package com.project.Christian_Gonzalez_SocialMedia_Capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Christian_Gonzalez_SocialMedia_Capstone.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
