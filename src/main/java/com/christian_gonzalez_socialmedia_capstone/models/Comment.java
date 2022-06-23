package com.christian_gonzalez_socialmedia_capstone.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Data
@Entity
@Table
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long id;
	private String postText;
	private Date createdOn;
	// foreign key
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User userId;
	
	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Post postId;
	
	// getters and setters
	public User getUserId() {
		return userId;
	}
	public Post getPostId() {
		return postId;
	}
	public void setPostId(Post postId) {
		this.postId = postId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPostText() {
		return postText;
	}
	public void setPostText(String postText) {
		this.postText = postText;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
}
