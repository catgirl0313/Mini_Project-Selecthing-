package com.sparta.selecthing.comment;

import com.sparta.selecthing.board.Board;
import com.sparta.selecthing.member.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

//    //댓글 목록보기
//    public List<CommentResponseDto> showComments(Long boardId) {
//
//        //특정 게시글의 모든 댓글 불러오기
//        return commentRepository.findByBoardIdOrderByCreatedAtDesc() //DB에서 미리 정리에서 가져옴.//마지막에return써주면 끝ㅋ
//                .stream()
//                .map(CommentResponseDto::new)//commets -> commentsresponsedto
//                .collect(Collectors.toList());
//
//
//    }

    @Transactional
    public void writeComment(CommentSaveRequestDto commentSaveRequestDto) {
        Member member = memberRepository.findByNickname(commentSaveRequestDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));

        Board board = boardRepository.findById(commentSaveRequestDto.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("댓글 쓰기 실패 : 게시글 id를 찾을 수 없습니다."));

        commentRepository.save(comment.createComments(member, board, commentSaveRequestDto.getContent());
    }

//        Comment comment = new Comment();
//        comment.writeComment(member, board, commentSaveRequestDto.getContent());

//        Comment comment = Comment.builder()
//                        .user(user)
//                        .board(board)
//                        .content(commentSaveRequestDto.getContent())
//                        .build();
//
//        commentRepository.save(comment);


//        requestComment.setUser(user);
//        requestComment.setBoard(board);
//        commentRepository.save(requestComment);


    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }



}
