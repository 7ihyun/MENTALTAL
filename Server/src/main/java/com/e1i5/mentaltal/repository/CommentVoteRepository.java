package com.e1i5.mentaltal.repository;

import com.e1i5.mentaltal.entity.Comment;
import com.e1i5.mentaltal.entity.CommentVote;
import com.e1i5.mentaltal.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentVoteRepository extends JpaRepository<CommentVote, Long> {
    Optional<CommentVote> findByCommentAndMember(Comment comment, Member member);
    void deleteAllByComment(Comment comment);   // CommentService --> deleteComment
}
