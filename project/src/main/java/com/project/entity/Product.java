package com.project.entity;

import com.project.constant.Category;
import com.project.constant.ProductStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Getter @Setter @ToString
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성 전략
    private Long id ; // 상품 코드(primary key)

    @Column(nullable = false)
    private String name ; // 상품 이름
    private int price ; // 상품 가격

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // 열거형
    private Category category ; // 상품 카테고리
    private int point ; // 상품 포인트
    private LocalDateTime startDate ; // 공동구매 시작일자
    private LocalDateTime endDate ; // 공동구매 마감 날짜

    @Lob // CLOB(Character Large Object)  BLOL(Binary Large Object)
    private String description ; // 상품 설명

    @Enumerated(EnumType.STRING) //열거형
    private ProductStatus productStatus ; // 상품 판매 상태


}
