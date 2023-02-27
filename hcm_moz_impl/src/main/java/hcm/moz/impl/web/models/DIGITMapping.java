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
 * Class to save DHIS2 - Digit identifiers mapping
 */
@ApiModel(description = "Class to save DHIS2 - Digit identifiers mapping")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2023-02-27T12:04:22.736+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DIGITMapping   {
        @JsonProperty("digitMappingId")
        private Integer digitMappingId = null;

        @JsonProperty("dhis2RecordInternalID")
        private Integer dhis2RecordInternalID = null;

        @JsonProperty("digitId")
        private Integer digitId = null;

        @JsonProperty("digitEntityType")
        private String digitEntityType = null;

        @JsonProperty("auditDetails")
        private AuditDetails auditDetails = null;


}

