package com.example.demo;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Date;

@Aspect
@Component
public class MyAspect {

    @Around("execution (* com.example.demo.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint pjp)throws Throwable{
        Date start = new Date();

        Object obj = pjp.proceed();//執行切入點方法

        Date end = new Date();
        long time = end.getTime()-start.getTime();
        System.out.println("執行了: "+time+"ms");
        return obj;
    }
}
