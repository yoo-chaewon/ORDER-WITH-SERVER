package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public @ResponseBody
    /*
    String hello() {
        String greetings = "Hello";
        return greetings;
    }*/
    Map<String, String> hello(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "111");
        map.put("age", "2222");
        return map;
    }
}