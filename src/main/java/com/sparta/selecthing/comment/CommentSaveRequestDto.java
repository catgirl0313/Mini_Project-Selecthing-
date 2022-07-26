package com.sparta.selecthing.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentSaveRequestDto {

    private Long id;
    private String nickname;
    private String mbit;
    private String content;



}
