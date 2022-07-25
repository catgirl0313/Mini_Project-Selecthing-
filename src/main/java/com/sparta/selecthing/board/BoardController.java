package com.sparta.selecthing.board;

import com.sparta.selecthing.comment.CommentResponseDto;
import com.sparta.selecthing.comment.CommentSaveRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    //게시글 작성
/*    @PostMapping("/newBoards") //@AuthenticationPrincipal principalDetail principalDetail
    public String board(@RequestBody BoardRequestDto boardRequestDto,
                       @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long memberId = userDetails.getMember().getId();
        Board board = boardService.createBoard(boardRequestDto, memberId);

        return "200 ok";
    }
*/
    //실험용.
    @PostMapping("/newBoards/{id}") //@AuthenticationPrincipal principalDetail principalDetail
    public String board(@RequestBody BoardRequestDto boardRequestDto,
                       @PathVariable Long id){

        return boardService.createBoard(boardRequestDto, id);
    }

    //상세 게시글 열람
    @GetMapping("/board/{id}")
    public String showDetailedBoard(Model model, @PathVariable Long id) {
        model.addAttribute("board", boardService.showDetailedBoard(id));
        return "board";
    }
    //상세 게시글 삭제
    @DeleteMapping("/board/{id}")
    public ResponseEntity<BoardDto> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
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
