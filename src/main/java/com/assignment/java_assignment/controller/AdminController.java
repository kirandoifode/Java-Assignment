package com.assignment.java_assignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.java_assignment.model.Post;
import com.assignment.java_assignment.model.UserPosts;
import com.assignment.java_assignment.service.AdminService;

/**
 * @author kiran doifode
 *
 */
@RestController
@RequestMapping("/api")
public class AdminController {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;

	/**
	 * @return
	 */
	@GetMapping(value = "/allUsersPosts")
	public ResponseEntity<List<UserPosts>> getUsersPosts() {
		LOGGER.debug("Entering /allUsersPosts endpoint for view all users posts.");
		try {
			List<UserPosts> userPostsList = adminService.getAllUserPosts();

			if (userPostsList.isEmpty() || userPostsList.size() == 0) {
				LOGGER.warn(+userPostsList.size() + " records found for allUsersPosts request.");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			LOGGER.warn(+userPostsList.size() + " records found for allUsersPosts request.");
			return new ResponseEntity<List<UserPosts>>(userPostsList, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error occurred during allUsersPosts request processing. ", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @return
	 */
	@PostMapping(value = "/addPost")
	public ResponseEntity<Post> savePost(@Valid @RequestBody Post post) {
		LOGGER.debug("Entering /addPost endpoint for save post.");
		try {
			return new ResponseEntity<>(adminService.savePost(post), HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.error("Error occurred during addPost request processing. ", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @return
	 */
	@GetMapping(value = "/viewAllPost")
	public ResponseEntity<List<Post>> viewAllPost() {
		LOGGER.debug("Entering /viewAllPost endpoint to veiw all post.");
		try {
			List<Post> postList = adminService.findAllPost();
			
			if (postList.isEmpty() || postList.size() == 0) {
				LOGGER.warn(+postList.size() + " records found for allUsersPosts request.");
				return new ResponseEntity<List<Post>>(postList, HttpStatus.NO_CONTENT);
			}
			LOGGER.warn(+postList.size() + " records found for allUsersPosts request.");
			return new ResponseEntity<List<Post>>(postList, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error occurred during request processing. ", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @return
	 * You can use this end point for view all users posts on Browser..
	 */
	@GetMapping(value = "/getUsersPostView")
	public ModelAndView getUsersPostDetails() {
		List<UserPosts> userPostsList = adminService.getAllUserPosts();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user-posts-details");
		modelAndView.addObject("userPosts", userPostsList);
		return modelAndView;
	}

}
