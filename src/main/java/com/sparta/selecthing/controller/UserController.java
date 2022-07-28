package com.sparta.selecthing.controller;

import com.sparta.selecthing.dto.LoginIdCheckDto;
import com.sparta.selecthing.dto.SignupRequestDto;
import com.sparta.selecthing.model.Member;
import com.sparta.selecthing.security.UserDetailsImpl;
import com.sparta.selecthing.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(@Valid @RequestBody SignupRequestDto requestDto) {
        String res = userService.registerUser(requestDto);
        if (res.equals("")) {
            return "회원가입 성공";
        } else {
            return res;
        }
    }

    //아이디 중복 체크
    @GetMapping("user/login/userIds")
    public String idCheck(@RequestBody LoginIdCheckDto loginIdCheckDto){
        return userService.userIdCheck(loginIdCheckDto);
    }

    //닉네임 중복 체크
    @GetMapping("user/login/nickNames")
    public String nicNAmeCheck(@RequestBody LoginIdCheckDto loginIdCheckDto){
        return userService.userNicNameCheck(loginIdCheckDto);
    }

    //로그인 유저 정보
    @GetMapping("user/login/auth")
    public Member userDetails(@AuthenticationPrincipal UserDetailsImpl userDetails) {
       return userService.userInfo(userDetails);
    }
}