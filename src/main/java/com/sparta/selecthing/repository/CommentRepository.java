package com.sparta.selecthing.repository;

import com.sparta.selecthing.model.Comment;
import com.sparta.selecthing.dto.CommentResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
 //   List<Comment> findByBoardIdOrderByCreatedAtDesc();
    List<CommentResponseDto> findAllByBoardIdOrderByCreatedAtDesc(Long id);
}
