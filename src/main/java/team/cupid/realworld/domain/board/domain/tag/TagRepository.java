package team.cupid.realworld.domain.board.domain.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Boolean existsByName(String name);
    Optional<Tag> findByName(String name);
}
