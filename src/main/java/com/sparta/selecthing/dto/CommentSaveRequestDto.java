package com.sparta.selecthing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentSaveRequestDto {

    private String nickname;
    private String mbit;
    private String content;
}
