package com.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product_option_details")
@Getter @Setter
public class ProductOptionDetail {
    @Id
    @Column(name = "product_option_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    // 여러개의 옵션 디테일들은 하나의 옵션과 연관이 있습니다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_option_id")
    private ProductOption productOption ;

    @Column(name = "product_option_detail_name")
    private String name ; // 옵션 디테일 이름

    private int stock ; // 상품 재고

}
