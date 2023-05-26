package team.cupid.realworld.domain.comment.dto;

import lombok.Getter;
import team.cupid.realworld.domain.board.domain.Board;
import team.cupid.realworld.domain.comment.domain.Comment;
import team.cupid.realworld.domain.member.domain.Member;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class CommentSaveRequestDto {

    @NotNull
    private Long boardId;

    @NotBlank
    @Size(max = 255)
    private String comment;


    public Comment toEntity(Member member, Board board) {
        return Comment.builder()
                .board(board)
                .member(member)
                .comment(comment)
                .build();
    }
}
