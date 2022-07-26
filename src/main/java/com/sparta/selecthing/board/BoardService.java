package com.sparta.selecthing.board;

import com.sparta.selecthing.comment.Comment;
import com.sparta.selecthing.comment.CommentRepository;
import com.sparta.selecthing.comment.CommentSaveRequestDto;
import com.sparta.selecthing.member.Member;
import com.sparta.selecthing.member.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;

    public BoardService(BoardRepository boardRepository, CommentRepository commentRepository, MemberRepository memberRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
    }

    //글 상세보기
//    @Transactional
//    public BoardDto showDetailedBoard(Long boardId) {
//        Board entity = boardRepository.findById(boardId)
//                .orElseThrow(() -> new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다."));
//        return new BoardDto(entity);
//    }

    //게시글 등록
    @Transactional
    public String createBoard(BoardRequestDto boardRequestDto, Long memberId) {
       Member member_temp = memberRepository.findById(memberId)
               .orElseThrow(() -> new IllegalArgumentException("id 오류"));

        Board board = new Board(boardRequestDto, member_temp);

        boardRepository.save(board);

        return "ok";
    }

    @Transactional
    public Board showDetailedBoard(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다."));
    }

    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);

    }
}