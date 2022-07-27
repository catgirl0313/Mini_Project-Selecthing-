package com.sparta.selecthing.controller;

import com.sparta.selecthing.Main.MainResponseDto;
import com.sparta.selecthing.Main.MainService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MainController {
    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/selecthing") //메인 투척.
    public List<MainResponseDto> showMains() {
        return mainService.showMains();
    }
}
