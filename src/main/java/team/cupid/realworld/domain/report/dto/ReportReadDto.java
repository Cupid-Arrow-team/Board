package team.cupid.realworld.domain.report.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportReadDto {
    private Long listId;
    private String title;
    private String content;
    private String targetUserName;
    private LocalDateTime modifiedDate;

    public static ReportReadDto response() {
        return new ReportReadDto();
    }
}
