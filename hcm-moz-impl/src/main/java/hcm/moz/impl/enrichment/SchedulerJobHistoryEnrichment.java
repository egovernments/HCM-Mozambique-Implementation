package hcm.moz.impl.enrichment;

import hcm.moz.impl.web.models.AuditDetails;
import hcm.moz.impl.web.models.JobRequest;
import hcm.moz.impl.web.models.SchedulerJobHistory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SchedulerJobHistoryEnrichment {

    public void enrichSchedulerJobHistoryRecord(JobRequest jobRequest) {

        SchedulerJobHistory schedulerJobHistory = jobRequest.getJob();
        if (!jobRequest.getRequestInfo().getUserInfo().getUuid().isEmpty()) {
            // Enrich audit details
            AuditDetails auditDetails = AuditDetails.builder().createdBy(jobRequest.getRequestInfo().getUserInfo().getUuid()).createdTime(System.currentTimeMillis()).lastModifiedBy(jobRequest.getRequestInfo().getUserInfo().getUuid()).lastModifiedTime(System.currentTimeMillis()).build();
            schedulerJobHistory.setAuditDetails(auditDetails);
        }
    }

    public void enrichSchedulerJobHistoryRecordUponUpdate(JobRequest jobRequest) {
        // Enrich lastModifiedTime and lastModifiedBy in case of update
        jobRequest.getJob().getAuditDetails().setLastModifiedTime(System.currentTimeMillis());
        jobRequest.getJob().getAuditDetails().setLastModifiedBy(jobRequest.getRequestInfo().getUserInfo().getUuid());
    }


}
