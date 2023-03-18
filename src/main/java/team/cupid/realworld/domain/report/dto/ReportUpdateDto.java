package team.cupid.realworld.domain.report.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class ReportUpdateDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
