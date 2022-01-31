package ru.bod.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegControler {
    @GetMapping("reg")
    public String regUser(){
        return "reg";
    }

}
