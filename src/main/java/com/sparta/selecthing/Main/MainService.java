package com.sparta.selecthing.Main;

import com.sparta.selecthing.board.Board;
import com.sparta.selecthing.board.BoardRepository;
import com.sparta.selecthing.comment.CommentRepository;
import com.sparta.selecthing.member.MemberRepository;
import com.sparta.selecthing.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MainService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;

    public MainService(BoardRepository boardRepository, CommentRepository commentRepository, MemberRepository memberRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public List<MainResponseDto> showMains(MainResponseDto mainResponseDto) {
        List<Board> boardall = boardRepository.findAll();
    return null;
    }
}
