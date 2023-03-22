package com.example.blog.entity;

import com.example.blog.model.role.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

// ORM -> JAVA(혹은 다른 언어) Object -> 테이블로 매핑해주는 기술
@Data
@NoArgsConstructor @AllArgsConstructor
// @DynamicInsert // 구문 생성 시점에 null 이 아닌 컬럼들만 포함
@Builder // 빌더 패턴
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy = GenerationType.IDENTITY : 프로젝트에서 연결된 DB 의 넘버링 전략을 따라감
    @Column
    private int id; // 시퀀스(오라클), auto_increment(mySql)

    @Column(nullable = false, length = 20, unique = true)
    private String username;

    @Column(nullable = false, length = 100) // 123456 -> 해쉬(비밀코드 암호화)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    //@ColumnDefault("'user'") // 항상 " ' ' " 형태로 사용, 단, NUMBER 타입은 "" 로 사용
    @Enumerated(EnumType.STRING)
    private RoleType role; // Enum 을 쓰는게 좋음 -> 정해진 Enum 값만을 사용하도록 정할 수 있음(domain : 값의 범위)

    @CreationTimestamp // 시간 자동 입력
    private Timestamp createDate;


}
