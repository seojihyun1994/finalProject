package com.project.constant;

// 상품 카테고리 구분을 위한 열거형 데이터 타입

import lombok.Getter;

@Getter
public enum Category {

    PROCESSED_FOOD("가공식품"), FRESH_FOOD("신선식품"), KITCHEN("주방용품"), CLEANING("청소용품"), LIFE("생활용품"), DISPASABLE("일회용품"), SMALL_APPLIANCES("소형가전제품"), QUASI_DRUGS("의약외품");
    private String category_name ;
    Category(String category_name) {
        this.category_name = category_name ;
    }


}
