package com.christian_gonzalez_socialmedia_capstone.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
// using lombok, seems to be working
@Data
@Entity
@Table
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long id;
	private String title;
	private String postText;
	private Date createdOn;
	// foreign key for linking posts to users
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User userId;
	
	@OneToMany(targetEntity=Comment.class, cascade = {CascadeType.ALL})
	private List<Comment> commentLists;
	
	// getters and setters
	public long getId() {
		return id;
	}
	public List<Comment> getCommentLists() {
		return commentLists;
	}
	public void setCommentLists(List<Comment> commentLists) {
		this.commentLists = commentLists;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", postText=" + postText + ", createdOn=" + createdOn
				+ ", userId=" + userId + ", commentLists=" + commentLists + "]";
	}
	
	
}
