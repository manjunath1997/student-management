package com.java.studentmanagement.service;

import com.java.studentmanagement.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public List<Student> getStudents();

}

