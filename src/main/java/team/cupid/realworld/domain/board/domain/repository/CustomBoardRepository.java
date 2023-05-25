package team.cupid.realworld.domain.board.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import team.cupid.realworld.domain.board.dto.BoardReadResponseDto;

import java.util.List;
import java.util.Optional;

public interface CustomBoardRepository {

    Optional<List<BoardReadResponseDto>> readAllBoardReadDto(Long id);

    Optional<Page<BoardReadResponseDto>> readPageBoardReadDto(Long id, Pageable pageable);
}
