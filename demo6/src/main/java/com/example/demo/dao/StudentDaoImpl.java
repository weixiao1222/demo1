package com.example.demo.dao;

import com.example.demo.Student;
import com.example.demo.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDaoImpl implements StudentDao{


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Student getById(Integer studentId) {
        String sql = "SELECT id,name FROM student1 WHERE id =:Id";
        //Id與map.put的"Id"相同
        Map<String, Object> map = new HashMap<>();
        map.put("Id", studentId);

        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
        //list 中的泛型<>為StudentRowMapper中rowMap前的資料類型,query用在select

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
