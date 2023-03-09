package hcm.moz.impl.validators;

import hcm.moz.impl.repository.SchedulerJobHistoryRepository;
import hcm.moz.impl.web.models.JobRequest;
import hcm.moz.impl.web.models.SchedulerJobHistory;
import io.swagger.annotations.Authorization;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class SchedulerJobHistoryValidator {

    @Autowired
    private SchedulerJobHistoryRepository repository;

    public void validateSchedulerJobHistory(JobRequest jobRequest) {

            if(!ObjectUtils.isEmpty(jobRequest.getJob().getJobID()))
                throw new CustomException("EG_HCM_MOZ_IMPL_ERR", "jobId already exists for given job request");
    }

    public SchedulerJobHistory validateSchedulerJobHistoryExistence(JobRequest jobRequest) {
        return repository.getSchedulerJobHistory(jobRequest.getJob().getJobID());
    }
}
