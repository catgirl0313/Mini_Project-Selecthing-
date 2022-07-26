package com.sparta.selecthing.comment;

import com.sparta.selecthing.board.BoardDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

//    //상세 게시글 보기(댓글 포함?
//    @GetMapping("/api/{boardId}/comments") //게시글마다 댓글 다르니까~!
//    public List<CommentResponseDto> showComments(@PathVariable Long boardId) {
//        return commentService.showComments(boardId);
//
//    }

    //댓글 작성
    @PostMapping("/boards/{id}/comments") //@AuthenticationPrincipal principalDetail principalDetail
    public ResponseEntity<CommentResponseDto> writeComment(
            @PathVariable Long id, @RequestBody CommentSaveRequestDto commentSaveRequestDto){
//        String nickname = userDtails.getNickname();
//        commentSaveRequestDto.setNickname(userDtails.getMember().getNickname());
        commentService.writeComment(id, commentSaveRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(null);
    }
//    .
    //댓글 삭제
//    @DeleteMapping("/board/{boardId}/comments")
//    public ResponseEntity<BoardDto> deleteComment(@PathVariable Long commentId){
//        boardService.deleteComment(commentId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    // 댓글 목록 보기
//    @GetMapping("/api/comment/{articlesId}")
//    public ResponseEntity<Result<List<CommentResponseDto>>> showComments(@PathVariable Long articlesId) {
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new Result<List<CommentResponseDto>>(commentService.showComments(articlesId)));
//    }

}
