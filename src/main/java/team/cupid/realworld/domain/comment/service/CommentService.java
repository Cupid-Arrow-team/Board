package team.cupid.realworld.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.cupid.realworld.domain.board.domain.Board;
import team.cupid.realworld.domain.board.domain.repository.BoardRepository;
import team.cupid.realworld.domain.board.exception.BoardNotFoundException;
import team.cupid.realworld.domain.board.exception.NoMatchBoardWriterException;
import team.cupid.realworld.domain.comment.domain.Comment;
import team.cupid.realworld.domain.comment.domain.repository.CommentRepository;
import team.cupid.realworld.domain.comment.dto.*;
import team.cupid.realworld.domain.comment.exception.CommentNotFoundException;
import team.cupid.realworld.domain.member.domain.Member;
import team.cupid.realworld.domain.member.domain.repository.MemberRepository;
import team.cupid.realworld.domain.member.exception.MemberNotFoundException;
import team.cupid.realworld.global.error.exception.ErrorCode;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public CommentSaveResponseDto save(CommentSaveRequestDto request, Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        Board board = boardRepository.findById(request.getBoardId())
                .orElseThrow(() -> new BoardNotFoundException(ErrorCode.BOARD_NOT_FOUND));

        Comment comment = commentRepository.save(request.toEntity(member, board));

        return CommentSaveResponseDto.of(comment);
    }

    @Transactional(readOnly = true)
    public List<CommentReadResponseDto> read(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new BoardNotFoundException(ErrorCode.BOARD_NOT_FOUND));

        List<CommentReadResponseDto> list = commentRepository.findAllByBoard(board)
                .stream().map(e -> CommentReadResponseDto.of(e))
                .collect(Collectors.toList());

        return list;
    }

    public CommentUpdateResponseDto update(CommentUpdateRequestDto request, Long memberId) {
        Comment comment = commentRepository.findById(request.getCommentId())
                .orElseThrow(() -> new CommentNotFoundException(ErrorCode.COMMENT_NOT_FOUND));

        matchCommenter(comment, memberId);

        comment.update(request.toEntity());

        return CommentUpdateResponseDto.of(comment);
    }

    public ResponseEntity<Void> delete(Long commentId, Long memberId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException(ErrorCode.COMMENT_NOT_FOUND));

        matchCommenter(comment, memberId);

        commentRepository.deleteById(comment.getId());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // exception
    private void matchCommenter(Comment comment, Long memberId) {
        if (comment.getMember().getMemberId() != memberId) {
            throw new NoMatchBoardWriterException(ErrorCode.NO_MATCH_COMMENTER);
        }
    }
}
