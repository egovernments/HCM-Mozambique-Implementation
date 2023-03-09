package hcm.moz.impl.service;

import hcm.moz.impl.enrichment.SchedulerJobHistoryEnrichment;
import hcm.moz.impl.kafka.Producer;
import hcm.moz.impl.repository.SchedulerJobHistoryRepository;
import hcm.moz.impl.validators.SchedulerJobHistoryValidator;
import hcm.moz.impl.web.models.JobRequest;
import hcm.moz.impl.web.models.JobResponse;
import hcm.moz.impl.web.models.SchedulerJobHistory;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.egov.common.contract.request.RequestInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class SchedulerJobService {

    @Autowired
    private SchedulerJobHistoryValidator validator;

    @Autowired
    private SchedulerJobHistoryEnrichment enrichmentUtil;

    @Autowired
    private SchedulerJobHistoryRepository schedulerJobHistoryRepository;

    @Autowired
    private Producer producer;

    public SchedulerJobHistory createSchedulerJobHistoryRecord(JobRequest jobRequest) {

        // Validate SchedulerJobHistory record
        validator.validateSchedulerJobHistory(jobRequest);

        // Enrich SchedulerJobHistory record
        enrichmentUtil.enrichSchedulerJobHistoryRecord(jobRequest);
        jobRequest.getJob().setJobID("new_jon_id");

        // Push the SchedulerJobHistory record to the topic for persister to listen and persist
        producer.push("create-dhis2-job", jobRequest);

        // Return the response back
        return jobRequest.getJob();
    }

    public SchedulerJobHistory searchSchedulerJobHistoryRecord(String jobID) {
        // Fetch applications from database according to the given search criteria
        SchedulerJobHistory schedulerJobHistory = schedulerJobHistoryRepository.getSchedulerJobHistory(jobID);

        // If no schedulerJobHistory are found matching the given criteria, return an empty list
        if(CollectionUtils.isEmpty((Collection<?>) schedulerJobHistory))
            return SchedulerJobHistory.builder().build();

        // Otherwise return the found schedulerJobHistory
        return schedulerJobHistory;
    }

    public SchedulerJobHistory updateSchedulerJobHistoryRecord(JobRequest jobRequest) {
        // Validate whether the application that is being requested for update indeed exists
        SchedulerJobHistory existingSchedulerJobHistory = validator.validateSchedulerJobHistoryExistence(jobRequest);

        JobRequest copyJobRequest = new JobRequest();
        BeanUtils.copyProperties(jobRequest, copyJobRequest);

        if (StringUtils.isNotBlank(copyJobRequest.getJob().getExecutionStatus())) {
            existingSchedulerJobHistory.setExecutionStatus(copyJobRequest.getJob().getExecutionStatus());
        }
        existingSchedulerJobHistory.setExecutionCompletionTime(copyJobRequest.getJob().getExecutionCompletionTime());
        existingSchedulerJobHistory.setExecutionRetryCount(copyJobRequest.getJob().getExecutionRetryCount());


        jobRequest.setJob(existingSchedulerJobHistory);
        // Enrich application upon update
        enrichmentUtil.enrichSchedulerJobHistoryRecordUponUpdate(jobRequest);

        // Just like create request, update request will be handled asynchronously by the persister
        producer.push("update-dhis2-job", jobRequest);

        return jobRequest.getJob();
    }

    public SchedulerJobHistory deleteSchedulerJobHistoryRecord(JobRequest jobRequest) {
        // Validate whether the application that is being requested for update indeed exists
        SchedulerJobHistory existingSchedulerJobHistory = validator.validateSchedulerJobHistoryExistence(jobRequest);

        // Just like create request, update request will be handled asynchronously by the persister
        producer.push("delete-dhis2-job", jobRequest);

        return jobRequest.getJob();
    }




}
