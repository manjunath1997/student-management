package com.java.studentmanagement.service;

import com.java.studentmanagement.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getStudents();

    Optional<Student> getStudent(long studentId);

    Student addStudent(Student student);
}

