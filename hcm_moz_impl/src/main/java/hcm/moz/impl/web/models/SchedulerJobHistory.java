package hcm.moz.impl.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import hcm.moz.impl.web.models.AuditDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

/**
 * Class to save Job History
 */
@ApiModel(description = "Class to save Job History")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2023-02-27T12:04:22.736+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchedulerJobHistory   {
        @JsonProperty("jobID")
        private String jobID = null;

        @JsonProperty("jobType")
        private String jobType = null;

        @JsonProperty("JobName")
        private String jobName = null;

        @JsonProperty("ExecutionStartTime")
        private String executionStartTime = null;

        @JsonProperty("ExecutionCompletionTime")
        private String executionCompletionTime = null;

        @JsonProperty("ExecutionStatus")
        private String executionStatus = null;

        @JsonProperty("ExecutionRetryCount")
        private Integer executionRetryCount = null;

        @JsonProperty("auditDetails")
        private AuditDetails auditDetails = null;


}

