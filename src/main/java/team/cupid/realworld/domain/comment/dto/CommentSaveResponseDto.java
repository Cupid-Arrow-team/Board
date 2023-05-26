package team.cupid.realworld.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team.cupid.realworld.domain.comment.domain.Comment;

@Getter
@Builder
@AllArgsConstructor
public class CommentSaveResponseDto {

    private Long boardId;

    private Long memberId;

    private String comment;

    public static CommentSaveResponseDto of(Comment comment) {
        return CommentSaveResponseDto.builder()
                .boardId(comment.getBoard().getId())
                .memberId(comment.getMember().getMemberId())
                .comment(comment.getComment())
                .build();
    }
}
