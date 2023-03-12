package team.cupid.realworld.domain.report.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import team.cupid.realworld.domain.report.dto.ReportDto;
import team.cupid.realworld.domain.report.model.StatusTrue;

@Service
public class ReportService {

    public ResponseEntity<ReportDto.RoadResponse> loadForm(Long boardId) {

        /**
         * Scheduled to implement form load service
         */

        return null;
    }

    public ResponseEntity<StatusTrue> saveform(ReportDto.SaveRequest request) {

        /**
         * Scheduled to implement form save service
         */

        return null;
    }

    public ResponseEntity<ReportDto.ReadResponse> readReportList() {

        /**
         * Scheduled to implement report list read service
         */

        return null;
    }

    public ResponseEntity<StatusTrue> updateReport(ReportDto.UpdateRequest request) {

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
