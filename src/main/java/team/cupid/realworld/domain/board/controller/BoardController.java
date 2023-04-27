package team.cupid.realworld.domain.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import team.cupid.realworld.domain.board.dto.*;
import team.cupid.realworld.domain.board.service.BoardService;
import team.cupid.realworld.global.security.principal.CustomUserDetails;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<String> saveBoard(
            @RequestBody @Valid final BoardSaveDto request,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        return boardService.saveBoard(request, customUserDetails.getId());
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardReadDto>> readBoardList(
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        return boardService.readBoardList(customUserDetails.getId());
    }

    @PatchMapping
    public ResponseEntity<String> updateBoard(
            @RequestBody @Valid final BoardUpdateDto request,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        return boardService.updateBoard(request, customUserDetails.getId());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteReport(
            @RequestBody @Valid final BoardDeleteDto request,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        return boardService.deleteBoard(request, customUserDetails.getId());
    }

}
