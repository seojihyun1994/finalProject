package com.project.controller;

import com.project.dto.MemberSerchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class AdminController {

    @GetMapping(value = "/Home")
    public String adminMain(Model model){
        return "adminHome" ;
    }

    @GetMapping(value = {"/member/list","/member/{page}"})
    public String MemberList(MemberSerchDto dto, @PathVariable("page") Optional<Integer> page, Model model){
        return "/admin/meList" ;
    }


}
