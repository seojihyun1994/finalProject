package com.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class AdminMainController {

    @GetMapping(value = "/Home")
    public String adminMain(Model model){
        return "adminHome" ;
    }

    @GetMapping(value = "/products/new")
    public String productInsert(Model model){
        return "product/prInsertForm" ;
    }
}
