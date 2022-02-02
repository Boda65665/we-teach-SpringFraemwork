package ru.bod.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        System.out.println(name+" "+lastname);
        model.addAttribute("message: " + "Hello " + name + " " + lastname);
        return "hello";
    }

    @GetMapping("")
    public String regPage() {
        return "home";
    }
}