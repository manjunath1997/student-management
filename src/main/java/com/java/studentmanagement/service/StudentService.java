package com.java.studentmanagement.service;

import com.java.studentmanagement.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getStudents();

    Student getStudent(long studentId);

    Student addStudent(Student student);
}

