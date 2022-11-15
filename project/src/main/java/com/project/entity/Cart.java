package com.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "carts")
@Getter @Setter
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ; // Cart01

    // Cart는 Member의 member_id와 일대일 연관 관계를 맺도록 하겠습니다.
    // @JoinColumn에 매핑이 되는 외래키를 지정해 줍니다.
    @OneToOne(fetch = FetchType.LAZY) //Cart01
    @JoinColumn(name = "member_id") //Cart01
    private Member member ; // Cart가 Member를 참조하고 있습니다.

}
