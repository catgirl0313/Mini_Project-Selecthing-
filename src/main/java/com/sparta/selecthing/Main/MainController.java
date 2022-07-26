package com.sparta.selecthing.Main;

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
}
