package com.sparta.selecthing.board;


import com.sparta.selecthing.comment.CommentResponseDto;
import com.sparta.selecthing.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDto {
    private Long id;

    private String title;
    private String nickname;
    private String mbti;
    private String content;
    private String image;

    private boolean agree = false;
    private boolean disagree = false;
    private int agreeCount = 0;
    private int disagreeCount = 0;

//    private Board board;

    private List<CommentResponseDto> comments;


    public BoardDto(Board board, List<CommentResponseDto> comments) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.nickname = board.getMember().getNickname();
        this.mbti = board.getMember().getMbti();
        this.content = board.getContent();
        this.image = board.getImage();
        this.agreeCount = getAgreeCount();
        this.disagreeCount = getDisagreeCount();
        this.comments = comments;
    }
}
