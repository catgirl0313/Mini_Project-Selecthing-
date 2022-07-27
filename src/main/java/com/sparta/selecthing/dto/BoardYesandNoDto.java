package com.sparta.selecthing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //기본생성자를 생성해줌.
@AllArgsConstructor //전체변수를 생성하는 생성자를 만들어준다.
@Data //@Getter, @Setter 합쳐놓은 종합 선물 세트.
public class BoardYesandNoDto {
    private boolean agree;
    private boolean disagree;
    private int agreeCount;
    private int disagreeCount ;

    public BoardYesandNoDto(BoardYesandNoDto boardYesandNoDto)
    {
        this.agree = boardYesandNoDto.agree;
        this.disagree = boardYesandNoDto.disagree;
        this.disagreeCount = boardYesandNoDto.disagreeCount;
        this.agreeCount = boardYesandNoDto.agreeCount;
    }
}