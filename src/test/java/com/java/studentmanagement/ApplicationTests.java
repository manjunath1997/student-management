package com.java.studentmanagement;

import com.java.studentmanagement.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=StudentService.class)
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
