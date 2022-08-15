package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/test")

    public ResponseEntity<String> test(){
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello world");
    }
    @RequestMapping("/test1")
    public String test1(){
        throw new RuntimeException("test1 error");
    }

    @RequestMapping("/test2")
    public String test2(){
        throw new IllegalArgumentException("test2 error");
    }

    @RequestMapping("/test3")
    public String test3(){
        System.out.println("執行test3");
        return "hello test3";
    }
    @RequestMapping("/test4")
    public String test4(){
        System.out.println("執行test4");
        return "hello test4";
    }
}
