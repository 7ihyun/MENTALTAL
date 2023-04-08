package com.e1i5.mentaltal.repository;

import com.e1i5.mentaltal.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Long countBoardByMember_MemberId(long memberId);

}
