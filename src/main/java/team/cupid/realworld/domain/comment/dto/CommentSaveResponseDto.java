package team.cupid.realworld.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team.cupid.realworld.domain.comment.domain.Comment;

@Getter
@Builder
@AllArgsConstructor
public class CommentSaveResponseDto {

    private Long commentId;

    private Long boardId;

    private String comment;

    public static CommentSaveResponseDto of(Comment comment) {
        return CommentSaveResponseDto.builder()
                .commentId(comment.getId())
                .boardId(comment.getBoard().getId())
                .comment(comment.getComment())
                .build();
    }
}
