package com.christian_gonzalez_socialmedia_capstone.controllers;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.christian_gonzalez_socialmedia_capstone.models.Comment;
import com.christian_gonzalez_socialmedia_capstone.models.Post;
import com.christian_gonzalez_socialmedia_capstone.models.Role;
import com.christian_gonzalez_socialmedia_capstone.models.User;
import com.christian_gonzalez_socialmedia_capstone.security.UserRegistrationDto;
import com.christian_gonzalez_socialmedia_capstone.security.UserServiceImpl;


@Controller
public class MainController {
	
	@Autowired
	PostController postController;
	
	@Autowired
	CommentController commentController;
	
	@Autowired
	UserController userController;
	
	
	// index
	@GetMapping("/")
	public String allPosts(Model model) {
		
		List<Post> ResultSet = postController.getPosts();
		
		model.addAttribute("postList", ResultSet);
		model.addAttribute("post", new Post());
		
		return "index";
	}
	
	// post page
	@GetMapping("/posts/{id}")
	public String posts(Model model, @PathVariable("id") String id) {
		long pathId = Long.parseLong(id);
		
		Post single = postController.getPost(pathId);
		
		List<Comment> commentList = commentController.getComment(pathId);
		
		model.addAttribute("commentList", commentList);
		
		Comment newComment = new Comment();
		
		model.addAttribute("post", single);
		model.addAttribute("comment", newComment);
		
		// model.addAttribute(id)
		return "posts";
	}
	
//	@PostMapping("/posts/{id}")
//	public void savecomment(@PathVariable("id") Long id, @RequestBody Comment comment){
//		Comment saving = comment;
//		
//		commentController.saveComment(saving, id);
//	}
	
	// about
	@GetMapping("/about")
	public String about(Model model) {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		User user = new User();
		user.setUsername(userDetails.getUsername());
		model.addAttribute("user", user);
		return "about";
	}

	// login
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex(Model model) {
    	
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	    	
    	List<Post> posts = postController.getUserPost(userDetails.getUsername());
    	
    	model.addAttribute("postList", posts);
    	
        return "user";
    }
}
