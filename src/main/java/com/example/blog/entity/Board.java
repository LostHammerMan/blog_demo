package com.example.blog.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터
    private String content; // 섬머노트 라이브러리 <html> 태그가 섞여서 디자인이 됨

    @ColumnDefault("0")
    private int count; // 조회수

    @ManyToOne(fetch = FetchType.EAGER) // Many(Board) to One(User) -> 한명의 유저가 여러 개의 게시글 작성 가능
    @JoinColumn(name = "userId")
    private User user; // DB 는 오브젝트롤 저장할 수 없음. FK 사용
                       // 자바는 오브젝트를 저장할 수 있음

    //@JoinColumn(name = "replyId")  : 필요 없음
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy = "필드 이름" : 연관관계의 주인이 아님(FK 아님) -> DB에 컬럼을 만들지 말라
    private List<Reply> reply; // 하나의 게시글은 여러 개의 댓글을 가짐(컬렉션 필요)
// fetch = FetchType.LAZY 해당 값이 필요할 때 생성됨
// fetch = FetchType.EAGER 해당 값을 바로 가져옴

    @CreationTimestamp
    private Timestamp createDate;
}
