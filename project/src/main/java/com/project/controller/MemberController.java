package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/members")
public class MemberController {
    private final String urlPrefix = "/member" ; // MemberController01


    @GetMapping(value = "/login")
    public String loginMember(){
        return "/member/memberLoginForm" ;
    }

}
