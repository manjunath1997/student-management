package com.java.studentmanagement.controller;

import com.java.studentmanagement.entity.Student;
import com.java.studentmanagement.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
public class StudentControllerTests {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService mockStudentService;

    private final ArrayList<Student> students = new ArrayList<>();

    @BeforeEach
    public void setup() {
        students.add(new Student(14L, "Manju", "email"));
    }

    @Test
    public void givenStudents_whenGetStudents_thenReturnExpectedStudents() throws Exception {

        // given
        given(mockStudentService.getStudents())
                .willReturn(students);

        // when
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/students")
                        .accept(MediaType.APPLICATION_JSON))

                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(students.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(students.get(0).getName()))
                .andExpect(jsonPath("$[0].email").value(students.get(0).getEmail()));
    }
}
