package com.myapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/")
    public String home() {
        return "day4";
    }
    @GetMapping("/day2")
    public String day2(){ return "day2";}
}
