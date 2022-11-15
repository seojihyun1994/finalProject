package com.project.controller;

import com.project.dto.ProductFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class ProductController {

    @GetMapping(value = "/products/new") // 관리자가 [상품 등록] 메뉴 클릭
    public String productInsert(Model model){// ProductController02
        model.addAttribute("productFormDto", new ProductFormDto()) ;
        return "product/prInsertForm01" ;
    }
}
