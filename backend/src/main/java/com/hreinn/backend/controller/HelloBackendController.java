package com.hreinn.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloBackendController {

    @GetMapping
    public String helloWorld(){
        return "Hello World!";
    }
}
