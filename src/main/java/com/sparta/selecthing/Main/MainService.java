package com.sparta.selecthing.Main;

import com.sparta.selecthing.board.Board;
import com.sparta.selecthing.board.BoardRepository;
import com.sparta.selecthing.comment.CommentRepository;
import com.sparta.selecthing.member.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MainService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public MainService(BoardRepository boardRepository, CommentRepository commentRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public List<MainResponseDto> showMains(Long boardId) {
        List<Board> boardall = boardRepository.findAll();
        return null;
    }
}
