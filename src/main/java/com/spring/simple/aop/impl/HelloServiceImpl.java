package com.spring.simple.aop.impl;

import com.spring.simple.aop.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHelloWorld() {
        System.out.println("Hello world!");
    }
}
