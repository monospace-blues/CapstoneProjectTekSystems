package com.christian_gonzalez_socialmedia_capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christian_gonzalez_socialmedia_capstone.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
