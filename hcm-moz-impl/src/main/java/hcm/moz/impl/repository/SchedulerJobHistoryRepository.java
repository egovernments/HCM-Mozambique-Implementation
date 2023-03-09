package hcm.moz.impl.repository;

import hcm.moz.impl.repository.querybuilder.SchedulerJobHistoryQueryBuilder;
import hcm.moz.impl.repository.rowmapper.SchedulerJobHistoryRowMapper;
import hcm.moz.impl.web.models.SchedulerJobHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SchedulerJobHistoryRepository {

    @Autowired
    private SchedulerJobHistoryQueryBuilder queryBuilder;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SchedulerJobHistoryRowMapper rowMapper;

    public SchedulerJobHistory getSchedulerJobHistory(String jobID){
        List<Object> preparedStmtList = new ArrayList<>();
        String query = queryBuilder.getSchedulerJobHistorySearchQuery(jobID, preparedStmtList);
//        log.info("Final query: " + query);
        return jdbcTemplate.query(query, preparedStmtList.toArray(), rowMapper);
    }
}
