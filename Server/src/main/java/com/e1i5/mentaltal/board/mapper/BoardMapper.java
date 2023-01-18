package com.e1i5.mentaltal.board.mapper;

import com.e1i5.mentaltal.board.dto.*;
import com.e1i5.mentaltal.board.entity.Board;
import com.e1i5.mentaltal.comment.dto.CommentResponseDto;
import com.e1i5.mentaltal.comment.entity.Comment;
import com.e1i5.mentaltal.user.member.Member;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    default Board boardPostDtoToBoard(BoardPostDto boardPostDto) {
        Board board = new Board();
        Member member = new Member();

        board.setMid(boardPostDto.getMemberId());
        board.setTitle(boardPostDto.getTitle());
        board.setContent(boardPostDto.getContent());
//        board.setTags(boardPostDto.getTags());
        member.setMemberId(boardPostDto.getMemberId());

        return board;
    }

    default Board boardPatchDtoToBoard(BoardPatchDto boardPatchDto) {
        Board board = new Board();
        board.setBoardId(boardPatchDto.getBoardId());
        board.setMid(boardPatchDto.getMemberId());
        board.setTitle(boardPatchDto.getTitle());
        board.setContent(boardPatchDto.getContent());
//        board.setTags(boardPatchDto.getTags());
        board.setModifiedAt(LocalDateTime.now());

        return board;
    }

    default BoardResponseDto boardToBoardResponseDto(Board board) {
        if ( board == null) {
            return null;
        }
        long memberId = 0L;

        long boardId = board.getBoardId();
        String title = board.getTitle();
        String content = board.getContent();
        int viewCount = board.getViewCount();   // 조회수
        int voteCount = board.getVoteCount();   // 공감수
        long commentCount = board.getCommentCount();
        // 닉네임?
        LocalDateTime createdAt = board.getCreatedAt();
        LocalDateTime modifiedAt = board.getModifiedAt();

        if ( board.getMid() != null) {
            memberId = board.getMid();
        }

        String nickName = board.getMember().getNickName();

        BoardResponseDto boardResponseDto =
                new BoardResponseDto(boardId, memberId, title, content, viewCount, voteCount, commentCount, nickName, createdAt, modifiedAt);

        return boardResponseDto;
    }

    List<BoardResponseDto> boardToBoardResponses(List<Board> boards);

//    Board boardDeleteDtoToBoard(BoardDeleteDto boardDeleteDto);


    default BoardGetResponseDto boardToBoardGetResponseDto(Board board) {
        List<Comment> comments = board.getComments();

        BoardGetResponseDto boardGetResponseDto = new BoardGetResponseDto();

        boardGetResponseDto.setBoardId(board.getBoardId());
        boardGetResponseDto.setMemberId(board.getMember().getMemberId());
        boardGetResponseDto.setTitle(board.getTitle());
        boardGetResponseDto.setContent(board.getContent());
        boardGetResponseDto.setViewCount(board.getViewCount()); // 조회수
        boardGetResponseDto.setVoteCount(board.getVoteCount()); // 공감수
        boardGetResponseDto.setCreatedAt(board.getCreatedAt());
        boardGetResponseDto.setModifiedAt(board.getModifiedAt());
        boardGetResponseDto.setCommentCount(board.getCommentCount());
        boardGetResponseDto.setNickName(board.getMember().getNickName());
        boardGetResponseDto.setComment(
                boardToCommentResponseDtos(comments)
        );
        // tag

        return boardGetResponseDto;
    }

    default List<CommentResponseDto> boardToCommentResponseDtos(List<Comment> comments) {

        return comments
                .stream()
                .map(comment -> CommentResponseDto
                        .builder()
                        .commentId(comment.getCommentId())
                        .content(comment.getContent())
                        .createdAt(comment.getCreatedAt())
                        .modifiedAt(comment.getModifiedAt())
                        .viewCount(comment.getViewCount())
                        .voteCount(comment.getVoteCount())
                        .boardId(comment.getBoard().getBoardId())
                        .memberId(comment.getMember().getMemberId())
                        .nickName(comment.getMember().getNickName())
                        .build()
                ).collect(Collectors.toList());
    }

    default List<BoardResponseDto> boardsToBoardsResponseDto(List<Board> boards) {
        if (boards == null) {
            return null;
        }

        List<BoardResponseDto> list = new ArrayList<BoardResponseDto>(boards.size());
        for ( Board board : boards ) {
            board.setMid(board.getMember().getMemberId());
            board.setNickName(board.getMember().getNickName());
            list.add(boardToBoardResponseDto(board));
        }
        return list;

    }
}