package com.project.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// Entity의 생명 주기(생성, 변경 등등)에 대하여 리스닝에 관여합니다.
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass // 공통적으로 사용하는 정보들이 있는 클래스에 작성합니다.
@Getter @Setter
public abstract class BaseTimeEntity{
    @CreatedBy // Entity 생성시 날짜를 제가 자동으로 기록할게요.
    @Column(updatable = false) // Entity 수정시 이 컬럼은 갱신하지 않습니다.
    private LocalDateTime regDate ;

    @LastModifiedBy // Entity 수정시 날짜를 제가 자동으로 기록할게요.
    private LocalDateTime updateDate ;
}
