package com.assignment.java_assignment;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.assignment.java_assignment.controller.AdminController;

@SpringBootTest
class JavaAssignmentApplicationSmokeTest {
	
		@Autowired
		private AdminController controller;

		@Test
		public void contextLoads() throws Exception {
			assertThat(controller).isNotNull();
		}
}
