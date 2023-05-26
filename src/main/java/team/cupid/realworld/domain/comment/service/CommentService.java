package team.cupid.realworld.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.cupid.realworld.domain.board.domain.Board;
import team.cupid.realworld.domain.board.domain.repository.BoardRepository;
import team.cupid.realworld.domain.comment.domain.Comment;
import team.cupid.realworld.domain.comment.domain.repository.CommentRepository;
import team.cupid.realworld.domain.comment.dto.*;
import team.cupid.realworld.domain.member.domain.Member;
import team.cupid.realworld.domain.member.domain.repository.MemberRepository;

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
                .orElseThrow(() -> new RuntimeException("Member Not Found"));

        Board board = boardRepository.findById(request.getBoardId())
                .orElseThrow(() -> new RuntimeException("Board Not Found"));

        Comment comment = commentRepository.save(request.toEntity(member, board));

        return CommentSaveResponseDto.of(comment);
    }

    @Transactional(readOnly = true)
    public List<CommentReadResponseDto> read(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board Not Found"));

        List<CommentReadResponseDto> list = commentRepository.findAllByBoard(board)
                .stream().map(e -> CommentReadResponseDto.of(e))
                .collect(Collectors.toList());

        return list;
    }

    public CommentUpdateResponseDto update(CommentUpdateRequestDto request, Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member Not Found"));

        Comment comment = commentRepository.findById(request.getCommentId())
                .orElseThrow(() -> new RuntimeException("Comment Not Found"));

        /**
         * 댓글 작성자, 로그인한 유저 일치 예외처리
         */

        comment.update(request.toEntity());

        return CommentUpdateResponseDto.of(comment);
    }

    public ResponseEntity<Void> delete(Long commentId, Long memberId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment Not Found"));

        /**
         * 댓글 작성자, 로그인한 유저 일치 예외처리
         */

        commentRepository.deleteById(comment.getId());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
