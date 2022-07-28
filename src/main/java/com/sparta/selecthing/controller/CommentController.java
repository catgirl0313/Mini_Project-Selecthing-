package com.sparta.selecthing.controller;

import com.sparta.selecthing.security.UserDetailsImpl;
import com.sparta.selecthing.service.CommentService;
import com.sparta.selecthing.dto.CommentSaveRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
//@CrossOrigin("http://localhost:3000")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    //댓글 작성
    @PostMapping("/boards/{id}/comments") //@AuthenticationPrincipal principalDetail principalDetail
    public HttpStatus writeComment(
            @PathVariable Long id, @RequestBody CommentSaveRequestDto commentSaveRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long memberId = userDetails.getMember().getId();
        commentService.writeComment(id, commentSaveRequestDto, memberId);

        return HttpStatus.OK;
    }
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
