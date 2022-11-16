package com.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/location")
public class LocationController {

    @GetMapping(value = "/home")
    public String locationHome(Model model){
       return "location/home" ;
    }
}
