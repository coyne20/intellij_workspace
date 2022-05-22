package com.example.sbhelloworldedureka;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppConfiguration {

    @RequestMapping("/hello")
    public String hello(){
        return "A simple hello world nonsense!";
    }
}
