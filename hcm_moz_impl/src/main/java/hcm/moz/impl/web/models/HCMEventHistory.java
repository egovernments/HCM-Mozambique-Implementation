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
 * Class to track HCM events history associated with a job
 */
@ApiModel(description = "Class to track HCM events history associated with a job")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2023-02-27T12:04:22.736+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HCMEventHistory   {
        @JsonProperty("eventID")
        private String eventID = null;

        @JsonProperty("jobID")
        private String jobID = null;

        @JsonProperty("url")
        private String url = null;

        @JsonProperty("payload")
        private String payload = null;

        @JsonProperty("status")
        private Integer status = null;

        @JsonProperty("message")
        private String message = null;


}

