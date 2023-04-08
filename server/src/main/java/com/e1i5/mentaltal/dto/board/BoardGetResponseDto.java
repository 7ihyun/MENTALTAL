package com.e1i5.mentaltal.dto.board;

import com.e1i5.mentaltal.dto.comment.CommentResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BoardGetResponseDto {
    private long boardId;
    private long memberId;
    private String title;
    private String content;
    private String tags;
    private long voteCount;  // 공감수
    private long commentCount;
    private List<CommentResponseDto> comment;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String nickName;
}
