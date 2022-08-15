package com.example.demo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
public class StudentController {

    @Validated
    @PostMapping("/students")
    public String create(@RequestBody @Valid  Student student){

        return "執行資料庫的Create操作";
    }

    @GetMapping("/students/{studentId}")
    public String read(@PathVariable @Min(100) Integer studentId){
        return "執行資料庫read操作";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student){
        return "執行資料庫update操作";
    }

    @DeleteMapping("/students/{studentId}")
    public  String delete(@PathVariable Integer studentId){
        return "執行資料庫delete操作";
    }
}
