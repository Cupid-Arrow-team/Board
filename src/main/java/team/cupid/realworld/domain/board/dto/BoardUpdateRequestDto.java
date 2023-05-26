package team.cupid.realworld.domain.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.cupid.realworld.domain.board.domain.Board;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    @NotNull
    private Long boardId;
    @NotBlank
    @Size(min = 3, max = 30)
    private String title;
    @NotBlank
    @Size(max = 300)
    private String content;
    @Size(min = 3, max = 10)
    private List<@NotBlank String> tags;

    @Builder
    public BoardUpdateRequestDto(Long boardId, String title, String content, List<String> tags) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.tags = tags;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
