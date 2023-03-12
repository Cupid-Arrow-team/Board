package team.cupid.realworld.domain.report.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class ReportDto {

    @Getter
    public static class SaveRequest {
        @NotBlank
        private String title;
        @NotBlank
        private String content;
        @NotBlank
        private String type;
        @NotBlank
        private Long targetUserId;
    }

    @Getter
    public static class UpdateRequest {
        @NotBlank
        private String title;
        @NotBlank
        private String content;
    }

    @Getter
    public static class RoadResponse {
        private Long targetUserId;
    }

    @Getter
    public static class ReadResponse {
        private Long listId;
        private String title;
        private String content;
        private String targetUserName;
        private LocalDateTime modifiedDate;
    }
}
