package com.sparta.selecthing.service;

import com.sparta.selecthing.dto.BoardYesandNoDto;
import com.sparta.selecthing.exception.CustomExcepton;
import com.sparta.selecthing.model.Comment;
import com.sparta.selecthing.repository.CommentRepository;
import com.sparta.selecthing.dto.BoardDto;
import com.sparta.selecthing.dto.BoardRequestDto;
import com.sparta.selecthing.dto.CommentResponseDto;
import com.sparta.selecthing.model.Board;
import com.sparta.selecthing.repository.MemberRepository;
import com.sparta.selecthing.model.Member;
import com.sparta.selecthing.repository.BoardRepository;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
    public HttpStatus createBoard(BoardRequestDto boardRequestDto, Long memberId) {
        Member member_temp = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("id 오류"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String DateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).format(formatter);

        Board board = new Board(boardRequestDto, member_temp, DateTime);

        boardRepository.save(board);

        return HttpStatus.OK;
    }

    @Transactional
    public BoardDto showDetailedBoard(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() ->
                    new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다."));
        List<Comment> comments = commentRepository.findAllByBoardIdOrderByCreatedAtDesc(boardId);
        List<CommentResponseDto> commentCopy = new ArrayList<>();
        for(Comment temp : comments)
        {
            CommentResponseDto commentResponseDtoTemp = new CommentResponseDto(
                    temp.getId(),temp.getContent(),temp.getMember().getNickname(),
                    temp.getMbtiComment());
            commentCopy.add(commentResponseDtoTemp);
        }

        BoardDto boardDto = new BoardDto(board, commentCopy);
       return boardDto;
    }

    @Transactional
    public HttpStatus patchDetailsBoard(Long boardId, BoardYesandNoDto boardYesandNoDto, Long memberId) {
        int sum = 0;
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new CustomExcepton(HttpStatus.BAD_REQUEST));

        if (boardYesandNoDto.isAgree()) {
            if(boardYesandNoDto.getAgreeCount() != board.getAgreeCount()) {
                board.setAgreeCount(boardYesandNoDto.getAgreeCount());
                board.setAgree(boardYesandNoDto.isAgree());
            }
        }
        else{
            if (boardYesandNoDto.getAgreeCount() != board.getAgreeCount()) {
                board.setAgreeCount(boardYesandNoDto.getAgreeCount());
                board.setAgree(boardYesandNoDto.isAgree());
            }
        }
        if (boardYesandNoDto.isDisagree()) {
            if(boardYesandNoDto.getDisagreeCount() != board.getDisagreeCount()) {
                board.setDisagreeCount(boardYesandNoDto.getAgreeCount());
                board.setDisagree(boardYesandNoDto.isDisagree());
            }
        }
        else {
            if(boardYesandNoDto.getDisagreeCount() != board.getDisagreeCount()) {
                board.setDisagreeCount(boardYesandNoDto.getAgreeCount());
                board.setDisagree(boardYesandNoDto.isDisagree());
            }
        }

        boardRepository.save(board);

        return HttpStatus.OK;
    }



    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);

    }
}