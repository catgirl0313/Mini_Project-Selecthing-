package com.sparta.selecthing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sparta.selecthing.dto.BoardRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.dialect.TypeNames;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column //@Lob : 대용량 데이터
    private String content;

    @Column(length = 65535)
    private String image; //url제대로 되라.

    @Column
    private String mbti;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member; //DB는 객체를 저장할 수 없음. java는 가능.

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) //mappedBy 연관관계의 주인이 아니다(나는 FK가 아니에요) DB에 컬럼 만들지 마세요.
    @JsonIgnoreProperties({"board"})
    @OrderBy("id desc")
    private List<Comment> comments;

    //작성일자.
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    //누가 작성했는가?
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;

    public Board(BoardRequestDto boardRequestDto, Member member_temp) {
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
        this.image = boardRequestDto.getImage();
        this.member = member_temp;
        this.mbti = boardRequestDto.getMbti();
    }
}
