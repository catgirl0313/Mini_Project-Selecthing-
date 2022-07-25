package com.sparta.selecthing.Main;

import com.sparta.selecthing.board.Board;
import com.sparta.selecthing.board.BoardRepository;
import com.sparta.selecthing.comment.CommentRepository;
import com.sparta.selecthing.member.MemberRepository;
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
    public List<MainResponseDto> showMains() {
        List<Board> boardAll = boardRepository.findAll();
        List<MainResponseDto> mainResponseDtoList = null;
        for(Board temp : boardAll)
        {
            MainResponseDto mainResponseDtoTemp = new MainResponseDto(temp.getTitle(),temp.getImage(),temp.getContent(),temp.getMember());
            mainResponseDtoList.add(mainResponseDtoTemp);
        }

    return mainResponseDtoList;
    }
}
