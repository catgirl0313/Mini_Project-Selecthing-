package com.sparta.selecthing.board;

import com.sparta.selecthing.comment.Comment;
import com.sparta.selecthing.comment.CommentResponseDto;
import com.sparta.selecthing.comment.CommentSaveRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //상세 게시글 열람
    @GetMapping("/board/{id}")
    public Board showDetailedBoard(@PathVariable Long id) {
//        model.addAttribute("board", boardService.showDetailedBoard(id));
        return boardService.showDetailedBoard(id);
    }
    //상세 게시글 삭제
    @DeleteMapping("/board/{id}")
    public ResponseEntity<BoardDto> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //댓글 작성
    @PostMapping("/board/{id}/comment") //@AuthenticationPrincipal principalDetail principalDetail
    public ResponseEntity<CommentResponseDto> writeComment(
            @PathVariable Long id, @RequestBody CommentSaveRequestDto commentSaveRequestDto){
        boardService.writeComment(commentSaveRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //댓글 삭제
    @DeleteMapping("/board/{id}/comment/{commentId}")
    public ResponseEntity<BoardDto> deleteComment(@PathVariable Long commentId){
        boardService.deleteComment(commentId);
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


    //dto/?




}
