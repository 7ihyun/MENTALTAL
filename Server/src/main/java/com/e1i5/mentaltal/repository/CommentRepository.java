package com.e1i5.mentaltal.repository;

import com.e1i5.mentaltal.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    Long countCommentByMember_MemberId(Long memberId);
    // 멤버아이디를 통해서 멤버에서 답글 개수를 찾을거임
}

