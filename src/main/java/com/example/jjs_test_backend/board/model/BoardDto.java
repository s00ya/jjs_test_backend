package com.example.jjs_test_backend.board.model;

import com.example.jjs_test_backend.comment.model.Comment;
import com.example.jjs_test_backend.comment.model.CommentDto;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class BoardDto {
    @Getter
    public static class BoardReq {
        private String title;
        private String content;
        private String writer;

        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class BoardRes {
        private Long idx;
        private String title;
        private String content;
        private String writer;
        private List<CommentDto.CommentRes> commentList;

        public static BoardRes of(Board entity) {
            List<CommentDto.CommentRes> commentResList = (entity.getCommentList() == null)
                    ? new ArrayList<>()
                    : entity.getCommentList().stream()
                    .map(CommentDto.CommentRes::of)
                    .collect(Collectors.toList());

            return BoardRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .content(entity.getContent())
                    .writer(entity.getWriter())
                    .commentList(commentResList)
                    .build();
        }
    }

}
