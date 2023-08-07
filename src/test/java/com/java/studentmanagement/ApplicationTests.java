package com.java.studentmanagement;

import com.java.studentmanagement.controller.StudentController;
import com.java.studentmanagement.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private StudentController studentController;
	@Autowired
	private StudentService studentService;

	@Test
	public void contextLoads() {
		assertThat(studentController).isNotNull();
		assertThat(studentService).isNotNull();
	}
}
