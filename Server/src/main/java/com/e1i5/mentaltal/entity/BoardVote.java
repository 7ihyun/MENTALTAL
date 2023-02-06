package com.e1i5.mentaltal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BoardVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long voteId;

    private boolean voteCheck;

    @ManyToOne
    private Board board;

    @ManyToOne
    private Member member;

    public BoardVote(boolean voteCheck, Board board, Member member) {
        this.voteCheck = voteCheck;
        this.board = board;
        this.member = member;
    }
}
