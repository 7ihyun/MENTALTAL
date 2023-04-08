package com.e1i5.mentaltal.repository;

import com.e1i5.mentaltal.entity.Board;
import com.e1i5.mentaltal.entity.BoardVote;
import com.e1i5.mentaltal.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BoardVoteRepository extends JpaRepository<BoardVote, Long> {
    Optional<BoardVote> findByBoardAndMember(Board board, Member member);
    void deleteAllByBoard(Board board);
}
