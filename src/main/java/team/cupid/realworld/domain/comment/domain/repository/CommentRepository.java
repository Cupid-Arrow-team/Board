package team.cupid.realworld.domain.comment.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.cupid.realworld.domain.board.domain.Board;
import team.cupid.realworld.domain.comment.domain.Comment;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByBoard(Board board);
}
