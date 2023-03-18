package team.cupid.realworld.domain.report.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.cupid.realworld.domain.report.dto.ReportLoadDto;
import team.cupid.realworld.domain.report.dto.ReportReadDto;
import team.cupid.realworld.domain.report.dto.ReportSaveDto;
import team.cupid.realworld.domain.report.dto.ReportUpdateDto;
import team.cupid.realworld.domain.report.model.StatusTrue;
import team.cupid.realworld.domain.report.service.ReportService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/{boardid}")
    public ResponseEntity<ReportLoadDto> loadForm(
            @PathVariable("boardid") Long boardId
    ) {
        return reportService.loadForm(boardId);
    }

    @PostMapping()
    public ResponseEntity<StatusTrue> saveForm(
            @RequestBody @Valid final ReportSaveDto request
    ) {
        return reportService.saveform(request);
    }

    @GetMapping("/list")
    public ResponseEntity<ReportReadDto> readReportList(
    ) {
        return reportService.readReportList();
    }

    @PatchMapping("/{listid}")
    public ResponseEntity<StatusTrue> updateReport(
            @PathVariable("listid") Long listId,
            @RequestBody @Valid final ReportUpdateDto request
    ) {
        return reportService.updateReport(listId, request);
    }

    @DeleteMapping("/{listid}")
    public ResponseEntity<StatusTrue> deleteReport(
            @PathVariable("listid") Long listId
    ) {
        return reportService.deleteReport(listId);
    }
}
