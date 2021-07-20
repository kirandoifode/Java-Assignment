package com.assignment.java_assignment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assignment.java_assignment.model.Post;
import com.assignment.java_assignment.model.User;
import com.assignment.java_assignment.model.UserPosts;
import com.assignment.java_assignment.repository.AdminRepository;

@Service
public class AdminService{

	@Autowired
	private AdminRepository userRepository;
	
	RestTemplate restTemplate = new RestTemplate();

	public List<UserPosts> getAllUserPosts() {
		List<UserPosts> userPostsList = new ArrayList<UserPosts>();
		User[] usersArr = (User[]) restTemplate.getForObject("https://jsonplaceholder.typicode.com/users",
				User[].class);
		List<User> users = Arrays.stream(usersArr).collect(Collectors.toList());

		Post[] postArr = (Post[]) restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts",
				Post[].class);
		List<Post> posts = Arrays.stream(postArr).collect(Collectors.toList());

		if (posts != null && users != null) {
			for (User userObj : users) {
				for (Post postObj : posts) {
					if (userObj.getId() == postObj.getUserId()) {
						userPostsList.add(new UserPosts(userObj.getId(), userObj.getName(), userObj.getUsername(),
								userObj.getEmail(), postObj.getTitle(), postObj.getBody()));

					}
				}
			}
		}
		return userPostsList;
	}
	
	public Post savePost(Post post) {
		return userRepository.save(post);
	}
	
	public List<Post> findAllPost() {
		return (List<Post>) userRepository.findAll();
	}
	
}
