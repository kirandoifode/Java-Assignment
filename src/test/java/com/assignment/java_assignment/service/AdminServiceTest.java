package com.assignment.java_assignment.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assignment.java_assignment.model.Post;
import com.assignment.java_assignment.model.UserPosts;
import com.assignment.java_assignment.repository.AdminRepository;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

	@Mock
	private AdminRepository adminRepository;

	@InjectMocks
	private AdminService adminService;

	@Test
	void tesyShouldSavedPostSuccessFully() {
		final Post postObj = new Post(1L, 1L, "Title test", "Body test", false);

		when(adminRepository.save(Mockito.any(Post.class))).thenReturn(postObj);
		Post savedPost = adminService.savePost(postObj);

		assertThat(savedPost).isNotNull();
	}

	@Test
	void shouldReturnFindAll() {
		List<Post> posts = new ArrayList<Post>();
		posts.add(new Post(1L, 1L, "Title test1", "Body test1", false));
		posts.add(new Post(2L, 1L, "Title test2", "Body test2", false));
		posts.add(new Post(3L, 1L, "Title test3", "Body test3", false));

		when(adminRepository.findAll()).thenReturn(posts);

		List<Post> expected = adminService.findAllPost();

		assertEquals(expected, posts);
	}

	@Test
	void shouldReturnFindAllUserPosts() {
		List<UserPosts> posts = new ArrayList<UserPosts>();
		when(adminService.getAllUserPosts()).thenReturn(posts);

		List<UserPosts> expected = adminService.getAllUserPosts();

		assertThat(expected.size()).isEqualTo(100);
		assertThat(expected.get(0).getUsername()).isEqualTo("Bret");
	}
	
	@Test
	void shouldReturnAllPostByUserID() {
		List<Post> posts = new ArrayList<Post>();
		posts.add(new Post(1L, 11L, "Title test1", "Body test1", false));
		posts.add(new Post(2L, 11L, "Title test2", "Body test2", false));
		final long userId= 11L;
		when(adminRepository.findByUserId(userId)).thenReturn(posts);

		Optional<List<Post>> expected = adminService.findbyUserId(userId);

		assertEquals(expected.get(), posts);
	}
	
	@Test
	void shouldReturnAllPostsWhichAudited_True() {
		List<Post> posts = new ArrayList<Post>();
		posts.add(new Post(1L, 11L, "Title test1", "Body test1", true));
		posts.add(new Post(2L, 11L, "Title test2", "Body test2", true));
		final boolean audited= true;
		when(adminRepository.findAllAuditedPosts(audited)).thenReturn(posts);

		Optional<List<Post>> expected = adminService.findAllAuditedPost(audited);

		assertEquals(expected.get(), posts);
	}

	@Test
	public void testShouldFindNoPosts_If_Repository_Is_Empty() {
		Iterable<Post> posts = adminRepository.findAll();

		assertThat(posts).isEmpty();
	}
	
	@Test
	public void testShouldFindNoAuditedPostsByAudited_If_Repository_Is_Empty() {
		Iterable<Post> posts = adminRepository.findAllAuditedPosts(true);

		assertThat(posts).isEmpty();
	}
	
	@Test
	public void testShouldFindNoPostsByUserID_If_Repository_Is_Empty() {
		Iterable<Post> posts = adminRepository.findByUserId(101L);
		assertThat(posts).isEmpty();
	}

}
