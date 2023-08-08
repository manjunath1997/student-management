package com.java.studentmanagement.controller;

import com.java.studentmanagement.entity.Student;
import com.java.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @GetMapping("/students/{studentId}")
    public Optional<Student> getStudent(@PathVariable String studentId) {
        return this.studentService.getStudent(Long.parseLong(studentId));
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

}
