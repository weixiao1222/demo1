package com.example.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HpPrinter implements Printer{
    int count;


   @PostConstruct
    public void init(){
        count=5;
    }
    @Override
    public void  print(String msg) {
        System.out.println("Hp印表機 "+msg );
        System.out.println(count--);
    }
}
