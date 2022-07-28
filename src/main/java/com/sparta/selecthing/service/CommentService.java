package com.sparta.selecthing.service;

import com.sparta.selecthing.model.Board;
import com.sparta.selecthing.model.Comment;
import com.sparta.selecthing.model.Member;
import com.sparta.selecthing.repository.BoardRepository;
import com.sparta.selecthing.dto.CommentSaveRequestDto;
import com.sparta.selecthing.repository.CommentRepository;
import com.sparta.selecthing.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    public CommentService(CommentRepository commentRepository, BoardRepository boardRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
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
    public void writeComment(Long id, CommentSaveRequestDto commentSaveRequestDto,Long memberId){
        Member member = userRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("null"));

        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String DateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).format(formatter);

        Comment writeComment = new Comment(board, commentSaveRequestDto, DateTime, member);

        commentRepository.save(writeComment);
    }

//    @Transactional
//    public void writeComment(CommentSaveRequestDto commentSaveRequestDto) {
//        Member member = memberRepository.findByNickname(commentSaveRequestDto.getUsername())
//                .orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
//
//        Board board = boardRepository.findById(commentSaveRequestDto.getBoardId())
//                .orElseThrow(() -> new IllegalArgumentException("댓글 쓰기 실패 : 게시글 id를 찾을 수 없습니다."));
//
//        commentRepository.save(comment.createComments(member, board, commentSaveRequestDto.getContent());
//    }

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
