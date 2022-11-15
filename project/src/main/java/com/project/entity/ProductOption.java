package com.project.entity;

import com.project.constant.Option;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product_options")
@Getter @Setter
public class ProductOption {
    @Id
    @Column(name = "product_option_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "product_option_name")
    @Enumerated(EnumType.STRING)
    private Option name ; // 옵션 이름이며, 열거형 데이터 타입 입니다.

    // 하나의 옵션은 하나의 상품과 연관이 있습니다.
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product ;


}
