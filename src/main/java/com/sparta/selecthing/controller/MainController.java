package com.sparta.selecthing.controller;

import com.sparta.selecthing.Main.MainResponseDto;
import com.sparta.selecthing.Main.MainService;
import com.sparta.selecthing.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/selecthing") //메인 투척.
    public List<MainResponseDto> showMains() {
        return mainService.showMains();
    }

    @GetMapping("/")
    public String gooja(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return userDetails.getMember().getNickname();
    }
}
