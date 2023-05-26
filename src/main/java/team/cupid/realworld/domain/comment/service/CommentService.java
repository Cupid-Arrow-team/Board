package team.cupid.realworld.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.cupid.realworld.domain.comment.dto.CommentSaveRequestDto;
import team.cupid.realworld.domain.comment.dto.CommentSaveResponseDto;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    public CommentSaveResponseDto save(CommentSaveRequestDto request, Long memberId) {

        return null;
    }
}
