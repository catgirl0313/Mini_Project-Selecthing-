package com.sparta.selecthing.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@NoArgsConstructor //기본생성자를 생성해줌.
@AllArgsConstructor //전체변수를 생성하는 생성자를 만들어준다.
@Data //@Getter, @Setter 합쳐놓은 종합 선물 세트.
public class BoardRequestDto {
    private String username;
    private String nickName;
    private String title;
    private String content;
    private String image;
}
