package com.example.jjs_test_backend.comment;

import com.example.jjs_test_backend.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<CommentDto.CommentRes> create (
            @RequestBody CommentDto.CommentReq dto) {
        CommentDto.CommentRes response = commentService.create(dto);
        return ResponseEntity.ok(response);
    }
}
