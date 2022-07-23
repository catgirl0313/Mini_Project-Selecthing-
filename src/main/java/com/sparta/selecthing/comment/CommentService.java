package com.sparta.selecthing.comment;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    //댓글 목록보기
    public List<CommentResponseDto> showComments(Long boardId) {

        //특정 게시글의 모든 댓글 불러오기
        return commentRepository.findByBoardIdOrderByCreatedAtDesc(boardId) //DB에서 미리 정리에서 가져옴.//마지막에return써주면 끝ㅋ
                .stream()
                .map(CommentResponseDto::new)//commets -> commentsresponsedto
                .collect(Collectors.toList());


    }



}
