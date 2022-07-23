package com.sparta.selecthing.board;


import com.sparta.selecthing.comment.CommentResponseDto;
import com.sparta.selecthing.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDto {
    private Long id;

    private User user;
    private Board board;
    private List<CommentResponseDto> comments;
    private int agreeCount = 0;
    private int disagreeCount = 0;

//    public BoardDto(Board entity) {
//        this.id = entity.getId();
//        this.nickname = entity.getNickname();
//        this.mbti = entity.getMbti();
//        this.image = entity.getImage();
//        this.title = entity.getTitle();
//        this.content = entity.getContent();
//        this.agreeCount = entity.getAgreeCount();
//        this.disagreeCount = entity.getDisagreeCount();
//    }
}
