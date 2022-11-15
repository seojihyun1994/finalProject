package com.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product_images")
@Getter @Setter
public class ProductImage { // ProductImage01
    @Id
    @Column(name = "product_image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String imageName ; // 이미지 파일 이름 ('UUID'.확장자 형식의 이름)
    private String oriImageName ; // 업로드 된 파일의 원본 이미지 이름
    private String imageUrl ; // 이미지 조회 경로
    private String repImageYesNo ; // 대표 이미지이면 'Y' 값을 가집니다.

    // 여러개의 이미지들은 하나의 상품과 연관이 있습니다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product ;

    // 이미지 정보를 업데이트 해주는 메소드
    public void updateProduct(String oriImageName, String imageName, String imageUrl){
        this.oriImageName = oriImageName ;
        this.imageName = imageName ;
        this.imageUrl = imageUrl ;
    }
}

