package team.cupid.realworld.domain.comment.dto;

import lombok.Getter;
import team.cupid.realworld.domain.comment.domain.Comment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class CommentUpdateRequestDto {

    @NotNull
    private Long commentId;

    @NotBlank
    @Size(max = 255)
    private String comment;

    public Comment toEntity() {
        return Comment.builder()
                .comment(comment)
                .build();
    }
}
