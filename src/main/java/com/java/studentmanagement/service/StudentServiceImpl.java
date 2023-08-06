package com.java.studentmanagement.service;

import com.java.studentmanagement.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    List<Student> studentDummyRepo;

    public StudentServiceImpl() {
        studentDummyRepo = new ArrayList<>();
        studentDummyRepo.add(new Student(123L, "Amar", "amar@gmail.com"));
        studentDummyRepo.add(new Student(456L, "Akbar", "akbar@gmail.com"));
        studentDummyRepo.add(new Student(789L, "Anthony", "anthony@gmail.com"));
    }

    @Override
    public List<Student> getStudents() {
        return studentDummyRepo;
    }

}
