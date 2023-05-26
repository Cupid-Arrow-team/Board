package team.cupid.realworld.domain.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import team.cupid.realworld.domain.comment.dto.*;
import team.cupid.realworld.domain.comment.service.CommentService;
import team.cupid.realworld.global.security.principal.CustomUserDetails;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentSaveResponseDto> saveComment(
            @RequestBody @Valid final CommentSaveRequestDto request,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        CommentSaveResponseDto responseDto = commentService.save(request, customUserDetails.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<List<CommentReadResponseDto>> readComment(
            @PathVariable Long boardId
    ) {
        List<CommentReadResponseDto> responseDto = commentService.read(boardId);

        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping
    public ResponseEntity<CommentUpdateResponseDto> updateComment(
            @RequestBody @Valid final CommentUpdateRequestDto request,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        CommentUpdateResponseDto responseDto = commentService.update(request, customUserDetails.getId());

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long commentId,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        return commentService.delete(commentId, customUserDetails.getId());
    }

}
