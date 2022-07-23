package com.sparta.selecthing.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentSaveRequestDto {

    private Long userId;
    private Long boardId;
    private String content;
}
