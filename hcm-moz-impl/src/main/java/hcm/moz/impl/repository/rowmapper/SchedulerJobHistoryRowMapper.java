package hcm.moz.impl.repository.rowmapper;

import hcm.moz.impl.web.models.AuditDetails;
import hcm.moz.impl.web.models.SchedulerJobHistory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class SchedulerJobHistoryRowMapper implements ResultSetExtractor<SchedulerJobHistory> {
    @Override
    public SchedulerJobHistory extractData(ResultSet rs) throws SQLException, DataAccessException {

            Map<String, SchedulerJobHistory> schedulerJobHistoryMap = new LinkedHashMap<>();
            SchedulerJobHistory schedulerJobHistory = SchedulerJobHistory.builder().build();

        while (rs.next()) {
                String uuid = rs.getString("jobID");
                schedulerJobHistory = schedulerJobHistoryMap.get(uuid);

                if (schedulerJobHistory == null) {

                    Long lastModifiedTime = rs.getLong("lastModifiedTime");
                    if (rs.wasNull()) {
                        lastModifiedTime = null;
                    }

                    AuditDetails auditdetails = AuditDetails.builder()
                            .createdBy(rs.getString("createdBy"))
                            .createdTime(rs.getLong("createdTime"))
                            .lastModifiedBy(rs.getString("lastModifiedBy"))
                            .lastModifiedTime(lastModifiedTime)
                            .build();

                    schedulerJobHistory = SchedulerJobHistory.builder()
                            .jobID(rs.getString("jobID"))
                            .jobType(rs.getString("jobType"))
                            .jobName(rs.getString("jobName"))
                            .executionStartTime(rs.getTimestamp("executionStartTime").toLocalDateTime())
                            .executionCompletionTime(rs.getTimestamp("executionCompletionTime").toLocalDateTime())
                            .executionStatus(rs.getString("status"))
                            .executionRetryCount(rs.getInt("executionRetryCount"))
                            .auditDetails(auditdetails)
                            .build();
                }
            }
            return schedulerJobHistory;
        }

}
