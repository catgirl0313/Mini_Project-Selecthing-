package com.sparta.selecthing.board;

import com.sparta.selecthing.comment.CommentResponseDto;
import com.sparta.selecthing.comment.CommentSaveRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/newBoards/{id}") //@AuthenticationPrincipal principalDetail principalDetail
    public String board(@RequestBody BoardRequestDto boardRequestDto,
                       @PathVariable Long id){
        Long memberId = id;
        String board = boardService.createBoard(boardRequestDto, memberId);

        return "200 ok";
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
}
