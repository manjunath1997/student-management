package com.java.studentmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    static final String GREETING_PATH = "/hello";
    static final String GREETING_RESPONSE = "Hello World!";

    @GetMapping(GREETING_PATH)
    public String index() {
        return GREETING_RESPONSE;
    }

}
