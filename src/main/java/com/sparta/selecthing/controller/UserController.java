package com.sparta.selecthing.controller;

import com.sparta.selecthing.dto.LoginIdCheckDto;
import com.sparta.selecthing.dto.LoginNicnameCheckDto;
import com.sparta.selecthing.dto.LoginRequestDto;
import com.sparta.selecthing.dto.SignupRequestDto;
import com.sparta.selecthing.jwt.JwtTokenProvider;
import com.sparta.selecthing.security.UserDetailsImpl;
import com.sparta.selecthing.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 로그인
    @PostMapping("/user/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto) {
        if (userService.login(loginRequestDto)) {
            String token = jwtTokenProvider.createToken(loginRequestDto.getUsername());
            System.out.println(token);
            return token;
        } else {
            return "닉네임 또는 패스워드를 확인해주세요";
        }
    }

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

    //로그 아웃
    @PostMapping("/user/logout")
    public String logout(HttpServletRequest request){
        return userService.logout(request);
    }

    //아이디 중복 체크
    @GetMapping("user/login/userIds")
    public Boolean idCheck(@RequestBody LoginIdCheckDto loginIdCheckDto){
        return userService.userIdCheck(loginIdCheckDto);
    }

    //닉네임 중복 체크
    @GetMapping("user/login/userIds")
    public Boolean nicNAmeCheck(@RequestBody LoginNicnameCheckDto nicnameCheckDto){
        return userService.userNicNameCheck(nicnameCheckDto);
    }

    //로그인 유저 정보
    @GetMapping("user/login/auth")
    public String userDetails(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return userDetails.getUsername();
    }
}