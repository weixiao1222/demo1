package com.example.demo.service;

import com.example.demo.Student;
import com.example.demo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService{

    @Autowired
    @Qualifier("studentDaoImpl")
    private StudentDao studentDao;
    //可DI所有介面StudentDao下所有implement的類別 因為只有一個 不須Qualifier

    @Override
    public Student getById(Integer studentId) {
        return studentDao.getById(studentId);
    }
}
