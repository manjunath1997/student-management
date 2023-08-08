package com.java.studentmanagement.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.java.studentmanagement.entity.Student;
import com.java.studentmanagement.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.BDDMockito.given;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTests {

    @Mock // field to be injected as a mock
    private StudentRepository mockStudentRepository;

    @InjectMocks // field that receives the mocked injections
    private StudentServiceImpl studentService;

    private Student student;

    @BeforeEach
    public void setup() {
        student = new Student(14L, "Manju", "some@email");
    }

    @Test
    public void givenStudent_whenAddStudent_thenReturnExpectedStudent() {

        // given
        given(mockStudentRepository.save(student))
                .willReturn(student);

        // when
        Student addStudentResponse = studentService.addStudent(student);

        // then
        assertThat(addStudentResponse).isNotNull();
        assertThat(addStudentResponse.getId()).isEqualTo(student.getId());
        assertThat(addStudentResponse).isEqualTo(student);
    }
}
