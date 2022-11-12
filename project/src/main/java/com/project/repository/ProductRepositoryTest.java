package com.project.repository;

import com.project.constant.Category;
import com.project.constant.ProductStatus;
import com.project.entity.Product;
import com.project.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest // 이 클래스는 테스트 용으로 사용됩니다.
public class ProductRepositoryTest {
    @Autowired // 클래스 외부에서 객체에 의미있는 값을 부여하기 위하여 사용됩니다.
    ProductRepository productRepository ;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createProductTest(){
        Product product = new Product() ;
        product.setName("사과");
        product.setCategory(Category.FRESH_FOOD);
        product.setPrice(1000);
        product.setPoint(10);
        product.setStartDate(LocalDateTime.now());
        product.setEndDate(LocalDateTime.now());
        product.setDescription("맛있어요");
        product.setProductStatus(ProductStatus.SELL);

        Product savedItem = productRepository.save(product) ;
        System.out.println(savedItem.toString());
    }

    @Test
    @DisplayName("데이터 생성(for QuerydslPredicateExecutor)")
    public void createProductListNew(){
        String[] fruit = {"사과","배","오렌지"} ;
        String[] descreiption = {"달아요","맛있어요","맛없어요","떫어요"} ;
        int[] price = {111, 222, 333, 444, 555} ;

        for (int i = 1; i <= 30 ; i++) {
            Product product = new Product() ;
            // setting
            product.setName(fruit[i%fruit.length]);
            product.setPrice(price[i % price.length]);
            product.setDescription(descreiption[i % descreiption.length]);

            if(i%2 == 0){
                product.setProductStatus(ProductStatus.SELL);
            }else {
                product.setProductStatus(ProductStatus.SOLD_OUT);
            }

            product.setStartDate(LocalDateTime.now());
            product.setEndDate(LocalDateTime.now());
            product.setCategory(Category.FRESH_FOOD);

            Product savedBean = this.productRepository.save(product) ;
            System.out.println(savedBean.toString());

        }
    }

    @PersistenceContext // JPA가 동작하는 가상의 공간(space), 이 어노테이션이 em에게 의미있는 데이터를 주입(injection)해 줍니다.
    EntityManager em ; // 엔터티 관리자.

    @Test
    @DisplayName("query Dsl Test01")
    public void queryDslTest01(){
        // 상품 중에서 현재 판매중(SELL)인 상품을 가격 내림 차순으로 조회합니다.
        // 상품 설명에 "아" 글자가 포함되어 있는 행만 조회합니다.
         /*
            select * from products
            where product_status = 'SELL' and description like '%아%'
            order by price desc ;
        */
        // JPAQueryFactory 는 쿼리를 만들어 내기 위한 클래스
        JPAQueryFactory queryFactory = new JPAQueryFactory(em) ;
        QProduct qbean = QProduct.product ;
        JPAQuery<Product> query = queryFactory
                .selectFrom(qbean)
                .where(qbean.productStatus.eq(ProductStatus.SELL))
                .where(qbean.description.like("%"+"아"+"%"))
                .orderBy(qbean.price.desc()) ;

        List<Product> itemList = query.fetch() ;
        for (Product bean : itemList){
            System.out.println(bean.toString());
        }
    }

    @Test
    @DisplayName("query Dsl Test02")
    public void queryDslTest02(){
        // 현재 판매중(SELL)인 상품중에서, 단가가 200 초과이고, 세부 설명에 '어'가 포함되어 있는 상품을 조회해 보세요
        // 페이지당 2개씩 볼건데, 2페이지 볼 예정입니다.
         /*
            select * from products
            where product_status = 'SELL'
            and price > 200
            and description like '%어%'
            limit 2,2 ;
        */

        QProduct qbean = QProduct.product ;

        BooleanBuilder booleanBuilder = new BooleanBuilder() ;

        String description = "어" ;
        booleanBuilder.and(qbean.description.like("%"+description+"%")) ;

        int price = 200 ;
        booleanBuilder.and(qbean.price.gt(price)) ;

        booleanBuilder.and(qbean.productStatus.eq(ProductStatus.SELL)) ;

        int pageNumber = 2 - 1 ; // 현재 보고자 하는 페이지 번호 숫자는 1 이지만 2 페이지 보고 싶음(왜냐? 페이지 번호 0 부터 시작.)
        int pageSize = 2 ; // 페이지당 볼 건수
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        // 조건식, 페이징 객체
        Page<Product> pageList = this.productRepository.findAll(booleanBuilder, pageable) ;

        System.out.println("total element : "+ pageList.getTotalElements());

        List<Product> itemList = pageList.getContent() ;
        for(Product bean : itemList){
            System.out.println(bean.toString());
        }

    }
}
