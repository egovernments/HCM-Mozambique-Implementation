package hcm.moz.impl.repository.querybuilder;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchedulerJobHistoryQueryBuilder {

    private static final String BASE_DTR_QUERY = " SELECT dtr.jobID as jobID, dtr.jobType as jobType, dtr.jobName as jobName, dtr.executionStartTime as executionStartTime, dtr.executionCompletionTime as executionCompletionTime, dtr.status as status, dtr.executionRetryCount as executionRetryCount, dtr.createdBy as createdBy, dtr.lastModifiedBy as lastModifiedBy, dtr.createdTime as createdTime, dtr.lastModifiedTime as lastModifiedTime";


    private static final String FROM_TABLES = " FROM eg_scheduler_job_history dtr";


    public String getSchedulerJobHistorySearchQuery(String jobID, List<Object> preparedStmtList){
        StringBuilder query = new StringBuilder(BASE_DTR_QUERY);
        query.append(FROM_TABLES);
        query.append(" WHERE dtr.jobID = ? ");
        preparedStmtList.add(jobID);
        // order death registration applications based on their createdtime in latest first manner
        return query.toString();
    }

}

