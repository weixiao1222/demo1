package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //自動生成ID
    /**@PostMapping("/students")
        public String insert(@RequestBody Student student){

        String sql = "INSERT INTO student(name)VALUE (:studentName)";

        Map<String,Object> map = new HashMap<>();
        map.put("studentName",student.getName());


        KeyHolder keyHolder = new GeneratedKeyHolder();


        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);

        int id = keyHolder.getKey().intValue();
        System.out.println("mysql自動生成ID為: "+id);

        return "執行 INSERT sql";

    }**/
    //新增指定id及name
    @PostMapping("/students")
    public String insert(@RequestBody Student student){

    String sql = "INSERT INTO student(id,name)VALUE (:studentId,:studentName)";

    Map<String,Object> map = new HashMap<>();
        map.put("studentId",student.getId());
        map.put("studentName",student.getName());


    namedParameterJdbcTemplate.update(sql,map);

        System.out.println("執行");
    return "執行 INSERT sql";

    }
    //執行多次指令
    @PostMapping("/students/batch")
    public String insertList(@RequestBody List<Student> studentsList){
        String sql = "INSERT INTO student(name) VALUE(:studentName)";

        MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[studentsList.size()];

        for(int i=0; i<studentsList.size(); i++){
            Student student = studentsList.get(i);
            parameterSources[i]= new MapSqlParameterSource();
            parameterSources[i].addValue("studentName",student.getName());
        }
        namedParameterJdbcTemplate.batchUpdate(sql,parameterSources);

        return "執行多的一匹";
    }

    //刪除
    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId){

        String sql = "DELETE FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId",studentId);

        namedParameterJdbcTemplate.update(sql,map);

        return "執行DELETE sql";
    }
    //查詢
    @GetMapping("/students")
    public List<Student> select(){
        //responsebody的值須為List型態才能自動轉換為json

        String sql = "SELECT id,name FROM student";

        Map<String,Object> map = new HashMap<>();

        List<Student> list =namedParameterJdbcTemplate.query(sql,map,new StudentRowMapper());
        //list 中的泛型<>為StudentRowMapper中rowMap前的資料類型,query用在select

        return list;
    }

    @GetMapping("/students/{studentId}")
    public Student select(@PathVariable Integer studentId){
        //指定studentID

        String sql = "SELECT id,name FROM student WHERE id =:Id";
        //Id與map.put的"Id"相同
        Map<String,Object> map = new HashMap<>();
        map.put("Id",studentId);

        List<Student> list =namedParameterJdbcTemplate.query(sql,map,new StudentRowMapper());
        //list 中的泛型<>為StudentRowMapper中rowMap前的資料類型,query用在select

        if(list.size()>0){
            return list.get(0);
        }
        else {
            return null;
        }
    }
}
