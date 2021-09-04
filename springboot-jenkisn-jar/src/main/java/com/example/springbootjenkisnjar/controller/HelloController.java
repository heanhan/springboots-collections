package com.example.springbootjenkisnjar.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(String sayHi){
        return "请对我说"+sayHi;
    }
}
