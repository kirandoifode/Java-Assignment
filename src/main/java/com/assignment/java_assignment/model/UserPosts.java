package com.assignment.java_assignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPosts {

	@JsonProperty
	private Long id;
	@JsonProperty
    private String name;
	@JsonProperty
    private String username;
	@JsonProperty
    private String email;
	@JsonProperty
    private String title;
	@JsonProperty
    private String body;
	
	public UserPosts() {
		super();
	}
	
	public UserPosts(Long id, String name, String username, String email, String title, String body) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.title = title;
		this.body = body;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
