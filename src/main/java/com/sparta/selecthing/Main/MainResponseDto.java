package com.sparta.selecthing.Main;

import com.sparta.selecthing.model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MainResponseDto {
    private Long id;
    private String username;
    private String nickName;
    private String title;
    private String mbti;
    private String image;
    private String content;

    public MainResponseDto(Long id, String title, String image, String content,
                           Member member_temp,String mbti) {
        this.id = id;
        this.username = member_temp.getUsername();
        this.nickName = member_temp.getNickname();
        this.title = title;
        this.content = content;
        this.image = image;
        this.mbti = mbti;
    }
}

