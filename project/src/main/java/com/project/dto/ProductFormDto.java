package com.project.dto;

import com.project.constant.Category;
import com.project.constant.ProductStatus;
import com.project.entity.Product;
import com.project.entity.ProductOption;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter // 상품 등록시 기입한 데이터 정보를 전달해주는  dto 클래스(command 객체)
public class ProductFormDto { // ProductFormDto01
    private Long id ;

    @NotBlank(message = "상품명은 필수 입력 사항입니다.")
    private String name ;

    @NotBlank(message = "상품 가격은 필수 입력 사항입니다.")
    private int price ;

    private Category category ;

    @NotBlank(message = "상품 포인트는 필수 입력 사항입니다.")
    private int point ;

    @NotBlank(message = "공동구매 시작 날짜는 필수 입력 사항입니다.")
    private LocalDateTime startDate ; // 공동구매 시작일자

    @NotBlank(message = "공동구매 마감 날짜는 입력 사항입니다.")
    private LocalDateTime endDate ; // 공동구매 마감 날짜

    @NotBlank(message = "상세 설명은 필수 입력 사항입니다.")
    private String description ; // 상품 설명

    private ProductStatus productStatus ;

    // 상품 등록시 첨부할 이미지 목록을 저장할 리스트 컬렉션입니다.
    private List<ProductImageDto> productImageDtoList = new ArrayList<>() ;

    // 상품 이미지들의 id 목록을 저장합니다.
    // 차후 수정시 참조할 id입니다.
    private List<Long> productImageIds = new ArrayList<>() ;

    // 상품의 등록시 첨부할 옵션입니다.
    private ProductOption productOption ;

    private List<ProductOptionDetailDto> productOptionDetailDtoList = new ArrayList<>() ;

    private static ModelMapper modelMapper = new ModelMapper() ;

    public Product createProduct(){
        // ProductFormDto(dto) 객체의 정보를 Product(entity)에 매핑해줍니다.
        return modelMapper.map(this, Product.class) ;
    }

    public static ProductFormDto of(Product product){
        // Product(entity) 객체의 정보를 ProductFormDto(dto)에 매핑해줍니다.
        return modelMapper.map(product, ProductFormDto.class) ;
    }
}
