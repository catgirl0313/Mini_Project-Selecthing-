package com.sparta.selecthing.model;

import com.sparta.selecthing.dto.CommentSaveRequestDto;
import com.sparta.selecthing.model.Member;
import com.sparta.selecthing.model.Board;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
//@ToString(exclude = "board")
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String mbtiComment;

    @ManyToOne
    @JoinColumn(name = "Member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @CreatedDate
    @Column(updatable = false)
    private String createdAt;

    //누구에게 작성됬는가? => nickname or username
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;

    public Comment(Board board, CommentSaveRequestDto commentSaveRequestDto, String createdAt,Member member) {
        this.board = board;
        this.member = member;
        this.createdAt = createdAt;
        this.content = commentSaveRequestDto.getContent();
        this.mbtiComment = commentSaveRequestDto.getMbit();
    }

}
