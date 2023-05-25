package team.cupid.realworld.domain.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import team.cupid.realworld.domain.board.dto.*;
import team.cupid.realworld.domain.board.service.BoardService;
import team.cupid.realworld.global.common.CustomPageResponse;
import team.cupid.realworld.global.security.principal.CustomUserDetails;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardSaveResponseDto> saveBoard(
            @RequestBody @Valid final BoardSaveRequestDto request,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        BoardSaveResponseDto responseDto = boardService.save(request, customUserDetails.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/read/all")
    public ResponseEntity<List<BoardReadResponseDto>> readBoardAll(
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        List<BoardReadResponseDto> responseDto = boardService.readAll(customUserDetails.getId());

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/read/page")
    public ResponseEntity<CustomPageResponse> readBoardPage(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @RequestParam(name = "pageNumber") Integer pageNumber
    ) {
        Pageable pageable = PageRequest.of(pageNumber, 10);

        return ResponseEntity.ok(boardService.readPage(customUserDetails.getId(), pageable));
    }

    @PatchMapping
    public ResponseEntity<BoardUpdateResponseDto> updateBoard(
            @RequestBody @Valid final BoardUpdateRequestDto request,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        BoardUpdateResponseDto responseDto = boardService.update(request, customUserDetails.getId());

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteReport(
            @PathVariable Long boardId,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        return boardService.delete(boardId, customUserDetails.getId());
    }

}
