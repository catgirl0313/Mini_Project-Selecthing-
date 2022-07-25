package com.sparta.selecthing.Main;

import com.sparta.selecthing.board.BoardRequestDto;
import com.sparta.selecthing.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MainResponseDto {
    private String username;
    private String nickName;
    private String title;

    private String image;
    private String content;

    public MainResponseDto(BoardRequestDto boardRequestDto, Member member_temp) {
        this.username = member_temp.getUsername();
        this.nickName = member_temp.getNickname();
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
        this.image = boardRequestDto.getImage();
    }
}

