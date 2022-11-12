package com.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping(value = "/")
    public String adminMain(Model model){
        return "home" ;
    }
}
