package com.example.jjs_test_backend.board;

import com.example.jjs_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity<BoardDto.BoardRes> create(
            @RequestBody BoardDto.BoardReq dto) {
        BoardDto.BoardRes response = boardService.create(dto);
        return ResponseEntity.ok(response);

    }
}
