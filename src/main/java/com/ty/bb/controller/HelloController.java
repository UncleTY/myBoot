package com.ty.bb.controller;

import com.ty.bb.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${person.name}")
    private String name;

    @Autowired
    private Person person;

    @RequestMapping("getPerson")
    public Person getPerson() {
        return person;
    }

    @RequestMapping("/")
    public String sayHello(String name){
        return "Hello "+name;
    }
}
