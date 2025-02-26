package com.example.jjs_test_backend.board.model;

import lombok.Builder;
import lombok.Getter;


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

        public static BoardRes of(Board entity) {
            return BoardRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .content(entity.getContent())
                    .writer(entity.getWriter())
                    .build();
        }
    }

}
