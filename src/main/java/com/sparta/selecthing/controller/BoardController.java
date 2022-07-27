package com.sparta.selecthing.controller;


import com.sparta.selecthing.model.Member;
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
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
//@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //게시글 작성
    @PostMapping("/newBoards") //@AuthenticationPrincipal principalDetail principalDetail
    public String board(@RequestBody BoardRequestDto boardRequestDto){
                       // @AuthenticationPrincipal UserDetailsImpl userDetails){

       // Long memberId = userDetails.getMember().getId();

        String board = boardService.createBoard(boardRequestDto, 1L);

        return "200 ok";
    }
/*
    //실험용.
    @PostMapping("/newBoards/{id}") //@AuthenticationPrincipal principalDetail principalDetail
    public String board(@RequestBody BoardRequestDto boardRequestDto,
                       @PathVariable Long id){
        Long memberId = id;
        String board = boardService.createBoard(boardRequestDto, memberId);

        return "200 ok";
    }
*/
    //상세 게시글 열람
    @GetMapping("/boards/{boardId}/details")
    public BoardDto showDetailedBoard(@PathVariable Long boardId) {
//        model.addAttribute("board", boardService.showDetailedBoard(id));
        return boardService.showDetailedBoard(boardId);
    }

    //상세 게시글 삭제
    @DeleteMapping("/boards/{boardId}/details")
    public ResponseEntity<BoardDto> deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/board")
//    public ResponseEntity<Board> save(@RequestBody Board board){
//        boardService.writeBoard(board);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @PostMapping("/board/{id}/comment") //@AuthenticationPrincipal principalDetail principalDetail
//    public ResponseEntity<CommentResponseDto> commentSave(
//            @PathVariable id, @RequestBody Comment comment){
//        boardService.writeComment(user, boardId, comment);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
