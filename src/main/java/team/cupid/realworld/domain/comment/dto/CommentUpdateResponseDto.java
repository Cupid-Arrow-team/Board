package team.cupid.realworld.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team.cupid.realworld.domain.comment.domain.Comment;

@Getter
@Builder
@AllArgsConstructor
public class CommentUpdateResponseDto {

    private Long commentId;

    private String comment;

    public static CommentUpdateResponseDto of(Comment comment) {
        return CommentUpdateResponseDto.builder()
                .commentId(comment.getId())
                .comment(comment.getComment())
                .build();
    }
}
