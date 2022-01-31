package ru.bod.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello-world")
    public String sayHello() {
        return "hello";
    }
    @GetMapping("reg")
    public String regUser(){
        return "reg";
    }

}