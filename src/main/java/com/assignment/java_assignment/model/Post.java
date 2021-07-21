package com.assignment.java_assignment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Post implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	@NotNull(message = "Please enter user ID")
	private Long userId;
	@Column  
	@NotBlank(message = "Title is mandatory")
    private String title;
	@Column 
	@NotBlank(message = "Body is mandatory")
    private String body;
	@Column  
    private boolean audited;
	
    public Post() {}

	public Post(Long id, Long userId, String title, String body, boolean audited) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.body = body;
		this.audited = audited;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public boolean isAudited() {
		return audited;
	}

	public void setAudited(boolean audited) {
		this.audited = audited;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", userId=" + userId + ", title=" + title + ", body=" + body + ", audited=" + audited
				+ "]";
	}
    
}
