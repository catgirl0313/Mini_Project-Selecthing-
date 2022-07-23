package com.sparta.selecthing.Main;

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
    private String comment;
}
