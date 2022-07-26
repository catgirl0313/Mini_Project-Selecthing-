package com.sparta.selecthing.board;

import com.sparta.selecthing.comment.CommentRepository;
import com.sparta.selecthing.comment.CommentResponseDto;
import com.sparta.selecthing.member.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public BoardService(BoardRepository boardRepository, CommentRepository commentRepository, MemberRepository memberRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public BoardDto showDetailedBoard(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() ->
                    new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다."));
        List<CommentResponseDto> comments = commentRepository.findAllByBoardIdOrderByCreatedAtDesc(boardId);

        BoardDto boardDto = new BoardDto(board, comments);
        return boardDto;
    }

    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

}