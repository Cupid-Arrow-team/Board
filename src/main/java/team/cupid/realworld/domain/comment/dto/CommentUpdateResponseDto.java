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

    private String content;

    public static CommentReadResponseDto of(Comment comment) {
        return CommentReadResponseDto.builder()
                .commentId(comment.getId())
                .comment(comment.getComment())
                .build();
    }
}
