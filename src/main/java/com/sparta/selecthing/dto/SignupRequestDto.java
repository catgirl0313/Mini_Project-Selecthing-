package com.sparta.selecthing.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDto {
    private String username;
    private String nickname;
    private String password;
    private String password2;

}