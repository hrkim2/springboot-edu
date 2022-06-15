package com.example.springedu.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GuideController {

    @RequestMapping("")
    public String guide(){
        return "guide";
    }
}
