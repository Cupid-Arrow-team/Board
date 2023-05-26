package team.cupid.realworld.domain.comment.service;

import lombok.RequiredArgsConstructor;
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

    public List<CommentReadResponseDto> read(Long boardId) {

        return null;
    }

    public CommentUpdateResponseDto update(CommentUpdateRequestDto request, Long id) {

        return null;
    }

    public ResponseEntity<Void> delete(Long commentId, Long id) {

        return null;
    }
}
