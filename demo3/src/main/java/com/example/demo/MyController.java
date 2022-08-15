package com.example.demo;

import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Source;
import java.sql.SQLOutput;

@RestController
public class MyController {


    @RequestMapping("/test1")
    public String test1(@RequestParam Integer id,
                        @RequestParam(required = false) String name){
        System.out.println("id: "+id);
        System.out.println("name: "+name);
        return "hello test1";
    }
    @RequestMapping("/test2")
    public String test2(@RequestBody Student student){
        System.out.println("id: "+student.getId());
        System.out.println("name: "+student.getName());
        return  "hello test 2";
    }
    @RequestMapping("/test3")
    public String test3(@RequestHeader String info){
        System.out.println("你好: "+info);
        return "hello test3";
    }
    @RequestMapping("/test4/{id}/{name}")
    public String test4(@PathVariable Integer id,
                        @PathVariable String name){
        System.out.println("path id: "+id);
        System.out.println("path name: "+name);
        return  "hello test 4";

    }


}
