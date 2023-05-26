package team.cupid.realworld.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.cupid.realworld.domain.comment.dto.*;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    public CommentSaveResponseDto save(CommentSaveRequestDto request, Long memberId) {

        return null;
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
