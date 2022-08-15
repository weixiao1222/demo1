package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        //resultSet為存放資料庫所抓出來的數據,欄位是由sql SELECT決定的;
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        //SELECT決定抓取資料庫中的"id"欄位,或是index=1的第一個指令
        student.setName(resultSet.getString("name"));
        return  student;
    }
}
