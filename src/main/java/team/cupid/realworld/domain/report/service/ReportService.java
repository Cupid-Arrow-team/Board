package team.cupid.realworld.domain.report.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import team.cupid.realworld.domain.report.dto.ReportLoadDto;
import team.cupid.realworld.domain.report.dto.ReportReadDto;
import team.cupid.realworld.domain.report.dto.ReportSaveDto;
import team.cupid.realworld.domain.report.dto.ReportUpdateDto;
import team.cupid.realworld.domain.report.model.StatusTrue;

@Service
public class ReportService {

    public ResponseEntity<ReportLoadDto> loadForm(Long boardId) {

        /**
         * Scheduled to implement form load service
         */

        return null;
    }

    public ResponseEntity<StatusTrue> saveform(ReportSaveDto request) {

        /**
         * Scheduled to implement form save service
         */

        return null;
    }

    public ResponseEntity<ReportReadDto> readReportList() {

        /**
         * Scheduled to implement report list read service
         */

        return null;
    }

    public ResponseEntity<StatusTrue> updateReport(Long id, ReportUpdateDto request) {

        /**
         * Scheduled to implement form update service
         */

        return null;
    }

    public ResponseEntity<StatusTrue> deleteReport(Long listId) {

        /**
         * Scheduled to implement form delete service
         */

        return null;
    }


}
