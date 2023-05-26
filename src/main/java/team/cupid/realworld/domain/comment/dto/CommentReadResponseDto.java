package team.cupid.realworld.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team.cupid.realworld.domain.comment.domain.Comment;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CommentReadResponseDto {

    private Long commentId;

    private String commenter;

    private String comment;

    private LocalDateTime createDate;

    public static CommentReadResponseDto of(Comment comment) {
        return CommentReadResponseDto.builder()
                .commentId(comment.getId())
                .commenter(comment.getMember().getNickname())
                .comment(comment.getComment())
                .createDate(comment.getCreateTime())
                .build();
    }
}
