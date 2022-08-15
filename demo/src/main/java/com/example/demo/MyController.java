package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //成為bean
public class MyController {



    @Autowired
    @Qualifier("hpPrinter")
    private Printer printer;

    @RequestMapping("/test")
    public String test(){
        printer.print("hello world");

        return "變強!!";
    }
}
