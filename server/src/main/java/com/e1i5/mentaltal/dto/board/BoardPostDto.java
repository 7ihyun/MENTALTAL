package com.e1i5.mentaltal.dto.board;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardPostDto {
    private long memberId;
    private String title;
    private String content;
    private String tags;
}
