package com.example.jjs_test_backend.comment;

import com.example.jjs_test_backend.board.BoardRepository;
import com.example.jjs_test_backend.board.model.Board;
import com.example.jjs_test_backend.comment.model.Comment;
import com.example.jjs_test_backend.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public CommentDto.CommentRes create(CommentDto.CommentReq dto) {
        Board board = boardRepository.findById(dto.getBoardIdx())
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));
        Comment comment = commentRepository.save(dto.toEntity(board));
        return CommentDto.CommentRes.of(comment);
    }
}
