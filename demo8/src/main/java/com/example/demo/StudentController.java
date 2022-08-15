package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/students")
    public String insert(@RequestBody Student student){

        studentRepository.save(student);

        return "執行資料庫create";
    }

    @PutMapping("myGirlFriend/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student){

        Student s = studentRepository.findById(studentId).orElse(null);
        if(s != null){
            s.setName(student.getName());
            studentRepository.save(s);

            return "晚安瑞寶^^";
        }
        else
            return "update fail:data not exist";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId){

        studentRepository.deleteById(studentId);

        return "執行資料庫delete";
    }

    @GetMapping("/students/{studentId}")
    public Student read(@PathVariable Integer studentId){
       Student student = studentRepository.findById(studentId).orElse(null);
       //or else 找不到數據 student這個object就是null
        return student;
    }
}
