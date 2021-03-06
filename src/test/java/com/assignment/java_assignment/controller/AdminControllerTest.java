package com.assignment.java_assignment.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.assignment.java_assignment.model.Post;
import com.assignment.java_assignment.model.UserPosts;
import com.assignment.java_assignment.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author kiran doifode
 *
 */
@WebMvcTest(controllers = AdminController.class)
public class AdminControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper = new ObjectMapper();

	@MockBean
	private AdminService adminService;

	@Test
	public void testShouldFetchAllUsersPostsFrom_User_Post_API_Success() throws Exception {
		List<UserPosts> postList = new ArrayList<UserPosts>();
		postList.add(new UserPosts(1L, "Leanne Graham", "Bret", "Sincere@april.biz",
				"sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
				"quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto"));
		when(adminService.getAllUserPosts()).thenReturn(postList);

		mockMvc.perform(get("/api/allUsersPosts")).andExpect(status().isOk());
		assertThat(postList.size()).isEqualTo(1);
		assertThat(postList.get(0).getUsername()).isEqualTo("Bret");
	}

	@Test
	public void testShould_SaveNewPostInDB_Success() throws Exception {
		Post postObj = new Post(1L, 1L, "Title Post", "Body post", false);

		when(adminService.savePost(Mockito.any(Post.class))).thenReturn(postObj);
		String json = mapper.writeValueAsString(postObj);
		mockMvc.perform(post("/api/addPost").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.body").value("Body post"));
	}

	@Test
	public void testShouldFetchAllPostsFromDB_Success() throws Exception {
		Post postObj = new Post(1L, 1L, "Title test", "Body test", false);

		List<Post> postList = new ArrayList<>();
		postList.add(postObj);

		when(adminService.findAllPost()).thenReturn(postList);

		this.mockMvc.perform(get("/api/viewAllPost")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].body").value("Body test"));
	}

	@Test
	public void testShouldFetchAllPostsByUserID_Success() throws Exception {
		Post postObj = new Post(1L, 101L, "Title test1", "Body test1", false);
		List<Post> postList = new ArrayList<>();
		postList.add(postObj);

		when(adminService.findbyUserId(Mockito.anyLong())).thenReturn(Optional.ofNullable(postList));

		this.mockMvc.perform(get("/api/viewPostByUserId/101"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].userId").value(101L))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Title test1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].body").value("Body test1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].audited").value(false));
	}

	@Test
	public void testShouldFetchAllAuditedPosts_True_Success() throws Exception {
		Post postObj = new Post(1L, 101L, "Title test1", "Body test1", true);
		List<Post> postList = new ArrayList<>();
		postList.add(postObj);

		when(adminService.findAllAuditedPost(Mockito.anyBoolean())).thenReturn(Optional.ofNullable(postList));

		this.mockMvc.perform(get("/api/viewAllAuditedPost/true")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].body").value("Body test1"));
	}

	@Test
	public void testShould_Return404Exception_Success() throws Exception {
		mockMvc.perform(get("/simple").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(404));
	}

	@Test
	public void testShould_ReturnEmptyListOfPost_Success() throws Exception {
		Optional<List<Post>> posts = adminService.findAllAuditedPost(true);

		assertThat(posts).isEmpty();
	}

	@Test
	public void testShouldFindNoPosts_If_Repository_Is_Empty_Success() {
		Iterable<Post> posts = adminService.findAllPost();

		assertThat(posts).isEmpty();
	}

}
