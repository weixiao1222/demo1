package com.example.demo.controller;

import com.example.demo.Student;

import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    @GetMapping("/students/{studentId}")
    public Student select(@PathVariable Integer studentId){
        //指定studentID
        return studentService.getById(studentId);


    }
}
