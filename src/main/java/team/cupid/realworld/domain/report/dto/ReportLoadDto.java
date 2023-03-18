package team.cupid.realworld.domain.report.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportLoadDto {
    private Long targetUserId;

    public static ReportLoadDto response() {
        return new ReportLoadDto();
    }
}
