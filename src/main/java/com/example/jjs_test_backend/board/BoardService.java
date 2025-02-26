package com.example.jjs_test_backend.board;

import com.example.jjs_test_backend.board.model.Board;
import com.example.jjs_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardDto.BoardRes create(BoardDto.BoardReq dto) {
        Board board = boardRepository.save(dto.toEntity());
        return BoardDto.BoardRes.of(board);
    }
}
