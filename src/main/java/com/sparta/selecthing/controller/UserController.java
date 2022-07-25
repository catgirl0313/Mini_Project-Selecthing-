package com.sparta.selecthing.controller;

import com.sparta.selecthing.dto.LoginRequestDto;
import com.sparta.selecthing.dto.SignupRequestDto;
import com.sparta.selecthing.jwt.JwtTokenProvider;
import com.sparta.selecthing.service.UserService;
import lombok.RequiredArgsConstructor;
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
//            model.addAttribute("errortext", userService.registerUser(requestDto));
            return res;
        }
    }

    @PostMapping("/user/logout")
    public String logout(HttpServletRequest request){
        return userService.logout(request);
    }


}