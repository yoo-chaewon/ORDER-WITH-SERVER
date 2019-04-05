package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public @ResponseBody
    String hello() {
        String greetings = "Hello";
        return greetings;
    }
}
