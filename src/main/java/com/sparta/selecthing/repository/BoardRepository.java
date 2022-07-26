package com.sparta.selecthing.repository;

import com.sparta.selecthing.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long> {
}
