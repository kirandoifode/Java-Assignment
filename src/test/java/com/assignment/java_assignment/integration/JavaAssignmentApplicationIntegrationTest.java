package com.assignment.java_assignment.integration;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.assignment.java_assignment.JavaAssignmentApplication;
import com.assignment.java_assignment.model.Post;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = WebEnvironment.RANDOM_PORT,
		classes = JavaAssignmentApplication.class
	)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class JavaAssignmentApplicationIntegrationTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void testshould_SaveNewPostToDb() throws Exception {
		Post postObj = new Post();
		postObj.setId(1L);
		postObj.setUserId(1L);
		postObj.setTitle("Title post");
		postObj.setBody("Body post");
		postObj.setAudited(false);
		
		String json = mapper.writeValueAsString(postObj);
		mockMvc.perform(post("/api/addPost").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.body").value("Body post"));
	}
	
	@Test
	public void testShouldReturnAllPostsFromDb() throws Exception {

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/api/viewAllPost").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println(mvcResult.getResponse());
		
	}

	@Test
	public void testGetUsersListFromAPI() {
		assertTrue(
				this.restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", List.class).size() == 10);
	}

	@Test
	public void testGetAllPostsListFromAPI() {
		assertTrue(
				this.restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", List.class).size() == 100);
	}

	@Test
	public void testShouldReturnConsolidatedAllUsersPosts() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/allUsersPosts", List.class)
				.size() == 45);
	}
	
}