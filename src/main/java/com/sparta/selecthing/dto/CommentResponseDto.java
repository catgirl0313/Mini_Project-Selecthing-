package com.sparta.selecthing.dto;

import com.sparta.selecthing.model.Comment;
import lombok.Data;

@Data
public class CommentResponseDto {


    private Long id;

    private String content;

    private String nickname;

    private String mbti;


    public CommentResponseDto(Long id, String content, String nickname, String mbti) {
        this.id = id;
        this.content = content;
        this.nickname = nickname;
        this.mbti = mbti;
    }
}
