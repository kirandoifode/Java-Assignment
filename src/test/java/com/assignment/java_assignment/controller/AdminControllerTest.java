package com.assignment.java_assignment.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.assignment.java_assignment.model.Post;
import com.assignment.java_assignment.model.UserPosts;
import com.assignment.java_assignment.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AdminController.class)
public class AdminControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper = new ObjectMapper();

	@MockBean
	private AdminService adminService;

	@Test
	public void testShouldFetchAllUsersPostsDeatailFromAPI_User_Post() throws Exception {
		List<UserPosts> postList = new ArrayList<UserPosts>();
		postList.add(new UserPosts(1L, "Leanne Graham", "Bret", "Sincere@april.biz",
				"sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
				"quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto"));
		Mockito.when(adminService.getAllUserPosts()).thenReturn(postList);

		mockMvc.perform(get("/api/allUsersPosts")).andExpect(status().isOk());
		assertThat(postList.size()).isEqualTo(1);
		assertThat(postList.get(0).getUsername()).isEqualTo("Bret");
	}
	
	@Test
	public void testshould_SaveNewPostInDB() throws Exception {
		Post postObj = new Post();
		postObj.setId(1L);
		postObj.setUserId(1L);
		postObj.setTitle("Title post");
		postObj.setBody("Body post");
		postObj.setPublish(false);

		Mockito.when(adminService.savePost(ArgumentMatchers.any())).thenReturn(postObj);
		String json = mapper.writeValueAsString(postObj);
		mockMvc.perform(post("/api/addPost").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.body").value("Body post"));
	}

	@Test
	public void testShouldFetchAllPostsFromDB() throws Exception {
		Post postObj = new Post();
		postObj.setId(1L);
		postObj.setUserId(1L);
		postObj.setTitle("Title test");
		postObj.setBody("Body test");
		postObj.setPublish(false);

		List<Post> employeeList = new ArrayList<>();
		employeeList.add(postObj);

		given(adminService.findAllPost()).willReturn(employeeList);

		this.mockMvc.perform(get("/api/viewAllPost")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].body").value("Body test"));
	}

	@Test
	public void testShould_Return404Exception_thenSucceeds() throws Exception {
		mockMvc.perform(get("/simple").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(404));
	}

}
