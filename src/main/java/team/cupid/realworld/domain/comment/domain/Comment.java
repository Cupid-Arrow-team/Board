package team.cupid.realworld.domain.comment.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.cupid.realworld.domain.board.domain.Board;
import team.cupid.realworld.domain.member.domain.Member;
import team.cupid.realworld.global.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(CommentId.class)
public class Comment extends BaseEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String comment;

    @Builder
    public Comment(Board board, Member member, String comment) {
        this.board = board;
        this.member = member;
        this.comment = comment;
    }
}
