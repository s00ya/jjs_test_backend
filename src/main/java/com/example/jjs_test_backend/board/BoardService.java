package com.example.jjs_test_backend.board;

import com.example.jjs_test_backend.board.model.Board;
import com.example.jjs_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardDto.BoardRes create(BoardDto.BoardReq dto) {
        Board board = boardRepository.save(dto.toEntity());
        return BoardDto.BoardRes.of(board);
    }
    public BoardDto.BoardRes get(Long boardIdx) {
        Board board = boardRepository.findById(boardIdx).orElseThrow();
        return BoardDto.BoardRes.of(board);
    }

    public List<BoardDto.BoardRes> getList() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(BoardDto.BoardRes::of).toList();
    }
}
