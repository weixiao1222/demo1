package com.example.demo;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CanonPrinter implements Printer{

    @Override
    public void print(String msg) {
        System.out.println("Canon印表機 "+msg);

    }
}
