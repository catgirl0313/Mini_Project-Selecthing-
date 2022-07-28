package com.sparta.selecthing.controller;


import com.sparta.selecthing.dto.BoardYesandNoDto;


import com.sparta.selecthing.exception.CustomExcepton;
import com.sparta.selecthing.model.Board;
import com.sparta.selecthing.model.Member;
import com.sparta.selecthing.repository.BoardRepository;
import com.sparta.selecthing.repository.UserRepository;
import com.sparta.selecthing.security.UserDetailsImpl;
import com.sparta.selecthing.service.BoardService;
import com.sparta.selecthing.dto.BoardDto;
import com.sparta.selecthing.dto.BoardRequestDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("http://localhost:3000")
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public BoardController(BoardService boardService, BoardRepository boardRepository, UserRepository userRepository) {
        this.boardService = boardService;
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    //게시글 작성
    @PostMapping("/newBoards")
    public HttpStatus board(@RequestBody BoardRequestDto boardRequestDto,
                        @AuthenticationPrincipal UserDetailsImpl userDetails){

        Long memberId = userDetails.getMember().getId();

        return boardService.createBoard(boardRequestDto, memberId);
    }

    //상세 게시글 열람
    @GetMapping("/boards/{boardId}/details")
    public BoardDto showDetailedBoard(@PathVariable Long boardId) {
//        model.addAttribute("board", boardService.showDetailedBoard(id));
        return boardService.showDetailedBoard(boardId);
    }

    //찬반 count 변경
    @PatchMapping("/boards/{boardId}/details")
    public HttpStatus patchDetailsBoard(@PathVariable Long boardId, @RequestBody BoardYesandNoDto boardYenandNoDto,
                                        @AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        Long memberId = userDetails.getMember().getId();
        return boardService.patchDetailsBoard(boardId,boardYenandNoDto, memberId);
    }

    //상세 게시글 삭제
    @DeleteMapping("/boards/{boardId}/details")
    public HttpStatus deleteBoard(@PathVariable Long boardId,
                                                @AuthenticationPrincipal UserDetailsImpl userDetails) {

        Long memberId = userDetails.getMember().getId();

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new CustomExcepton(HttpStatus.BAD_REQUEST));
        Member member = userRepository.findById(memberId)
                .orElseThrow(() -> new CustomExcepton(HttpStatus.BAD_REQUEST));

        if(board.getMember().getNickname().equals(member.getNickname())) {
            boardService.deleteBoard(boardId);
        }

        return HttpStatus.OK;

    }

}
