package com.java.studentmanagement.repository;

import com.java.studentmanagement.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTests {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    StudentRepository studentRepository;

    private Student student;

    @BeforeEach
    public void setup() {
        student = Student.builder()
                .name("Manju")
                .email("some@email")
                .build();
    }

    @Test
    public void givenSavedStudent_whenFindStudentById_thenReturnExpectedStudent() {

        // given
        Student saveStudentResponse = studentRepository.save(student);

        // when
        Optional<Student> findStudentByIdResponse = studentRepository.findById(saveStudentResponse.getId());

        // then
        assertThat(findStudentByIdResponse.isPresent()).isTrue();
        assertThat(findStudentByIdResponse.get()).isEqualTo(saveStudentResponse);
    }
}
