package team.cupid.realworld.domain.report.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class ReportSaveDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private String type;
    @NotBlank
    private Long targetUserId;


}
