package com.java.studentmanagement.controller;

import com.java.studentmanagement.entity.Student;
import com.java.studentmanagement.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={StudentController.class, StudentService.class})
@WebMvcTest(StudentController.class)
public class StudentControllerTests {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService mockStudentService;

    @Test
    public void testValidResponseForGetStudents() throws Exception
    {
        ArrayList<Student> mockStudentsResponse = new ArrayList<>();
        mockStudentsResponse.add(new Student(14L, "Manju", "email"));
        when(mockStudentService.getStudents()).thenReturn(mockStudentsResponse);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/students")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":14,\"name\":\"Manju\",\"email\":\"email\"}]"));
    }
}
