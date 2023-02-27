package hcm.moz.impl.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.json.JSONObject;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

/**
 * Class to save DHIS2 Record
 */
@ApiModel(description = "Class to save DHIS2 Record")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2023-02-27T12:04:22.736+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DHIS2Record   {
        @JsonProperty("dhis2RecordInternalID")
        private Integer dhis2RecordInternalID = null;

        @JsonProperty("DHIS2ID")
        private String dhIS2ID = null;

        @JsonProperty("DHIS2EntityType")
        private String dhIS2EntityType = null;

        @JsonProperty("DHIS2DataPayload")
        private JSONObject dhIS2DataPayload = null;

        @JsonProperty("Source")
        private String source = null;

        @JsonProperty("auditDetails")
        private AuditDetails auditDetails = null;


}

