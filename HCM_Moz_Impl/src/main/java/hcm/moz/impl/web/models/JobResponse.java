package hcm.moz.impl.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * Contract class to receive job response
 */
@ApiModel(description = "Contract class to receive job response")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2023-02-24T11:34:41.894+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobResponse   {
        @JsonProperty("id")
        private String id = null;

        @JsonProperty("name")
        private String name = null;

        @JsonProperty("type")
        private String type = null;

        @JsonProperty("status")
        private String status = null;

        @JsonProperty("executionStartTime")
        private String executionStartTime = null;

        @JsonProperty("ExecutionCompletionTime")
        private String executionCompletionTime = null;

        @JsonProperty("ExecutionRetryCount")
        private String executionRetryCount = null;


}

