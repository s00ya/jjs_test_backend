package com.example.jjs_test_backend.board;

import com.example.jjs_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("read/{boardIdx}")
    public ResponseEntity<BoardDto.BoardRes> read(
            @PathVariable Long boardIdx) {
        BoardDto.BoardRes response = boardService.get(boardIdx);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.BoardRes>> list(){
        List<BoardDto.BoardRes> response = boardService.getList();
        return ResponseEntity.ok(response);
    }
}
