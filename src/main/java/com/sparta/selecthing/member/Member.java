package com.sparta.selecthing.member;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Member {
    @Id  //ID 할당 방법 1.직접 넣는 방식 (Setter, 생성자) 2.(JPA나)DB에게 할당 책임을 전가. (@GenerateValue)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql 은 identity. auto는 안 맞을 경우도 있어.
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String mbti;

    //@ColumnDfalt("'user'")
    //private String role; Enum - admin, user, manager 역할 입력해보기

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(nullable = false,updatable = false)
    private String createdBy; //누가 만들었는지도 알려줘야해 . 왜?

    @LastModifiedDate
    @Column(nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(nullable = false, insertable = false)
    private String updatedBy;


    public Member(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

}
