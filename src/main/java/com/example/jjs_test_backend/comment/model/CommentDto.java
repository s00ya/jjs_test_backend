package com.example.jjs_test_backend.comment.model;

import com.example.jjs_test_backend.board.model.Board;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public class CommentDto {
    @Getter
    public static class CommentReq {
        private String content;
        private String writer;
        private Long boardIdx;

        public Comment toEntity(Board board) {
            return Comment.builder()
                    .content(content)
                    .writer(writer)
                    .board(board)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class CommentRes {
        private Long idx;
        private String content;
        private String writer;

        public static CommentRes of(Comment entity) {
            return CommentRes.builder()
                    .idx(entity.getIdx())
                    .content(entity.getContent())
                    .writer(entity.getWriter())
                    .build();
        }
    }

}
