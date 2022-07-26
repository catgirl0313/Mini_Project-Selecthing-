package com.sparta.selecthing.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    private String username;
    private String password;
}
