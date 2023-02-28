package hcm.moz.impl.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import hcm.moz.impl.web.models.AuditDetails;
import hcm.moz.impl.web.models.RequestInfo;
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
 * Contract class to receive request. Array of  items are used in case of create, whereas single  item is used for update
 */
@ApiModel(description = "Contract class to receive request. Array of  items are used in case of create, whereas single  item is used for update")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2023-02-27T12:04:22.736+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DHIS2IngestionRequest   {
        @JsonProperty("name")
        private String name = null;

        @JsonProperty("dataType")
        private String dataType = null;

        @JsonProperty("RequestInfo")
        private RequestInfo requestInfo = null;

        @JsonProperty("tenantId")
        private String tenantId = null;

        @JsonProperty("auditDetails")
        private AuditDetails auditDetails = null;


}

