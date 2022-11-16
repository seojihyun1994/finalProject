package com.project.entity;

import com.project.constant.Role;
import com.project.dto.MemberFormDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "members")
@Getter @Setter
public class Member extends BaseEntity {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = true)
    private String name ; // 이름

    @Column(nullable = true)
    private String password ; // 비밀번호

    @Column(nullable = true)
    private String phoneNumber ; // 핸드폰 번호

    @Column(nullable = true, unique = true)
    private String email ; // 이메일이자 회원용 아이디.

    @Column(nullable = true)
    private String address ; // 주소
    private int mpoint ; // 회원 포인트
    private LocalDateTime joinDate ; // 가입일자

    @Column(nullable = true)
    private String gender ; // 성별
    private String remark ; // 비고사항

    @Enumerated(EnumType.STRING)
    private Role role ; // 회원 등급

    // 폼 화면에서 넘어오는 dto 객체를 이용하여 해당 회원에 대한 비밀번호 암호화를 처리해주는 메소드
    public static Member createMember(MemberFormDto dto, PasswordEncoder passwordEncoder){
        Member member = new Member() ;

        member.setName(dto.getName());
        member.setEmail(dto.getEmail());
        member.setAddress(dto.getAddress());
        member.setPhoneNumber(dto.getPhoneNumber());
        member.setGender(dto.getGender());
        member.setRole(Role.USER);

        String password = passwordEncoder.encode(dto.getPassword()) ; // 비밀번호 암호화
        member.setPassword(password);

        return member ;
    }
}
