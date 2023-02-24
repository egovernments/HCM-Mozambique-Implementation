package hcm.moz.impl.web.controllers;


import hcm.moz.impl.web.models.DHIS2IngestionRequest;
import hcm.moz.impl.web.models.DHIS2IngestionResponse;
import hcm.moz.impl.web.models.ErrorRes;
import hcm.moz.impl.web.models.JobRequest;
import hcm.moz.impl.web.models.JobResponse;
import org.springframework.core.io.Resource;
    import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.*;

    import javax.validation.constraints.*;
    import javax.validation.Valid;
    import javax.servlet.http.HttpServletRequest;
        import java.util.Optional;
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2023-02-24T11:34:41.894+05:30")

@Controller
    @RequestMapping("/hcm-moz-impl-services")
    public class V1ApiController{

        private final ObjectMapper objectMapper;

        private final HttpServletRequest request;

        @Autowired
        public V1ApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        }

                @RequestMapping(value="/v1/dhis2/facilities/ingest", method = RequestMethod.POST)
                public ResponseEntity<DHIS2IngestionResponse> v1Dhis2FacilitiesIngestPost(@ApiParam(value = "json string for DHIS2IngestionRequest object", required=true) @RequestParam(value="DHIS2IngestionRequest", required=true)  String dhIS2IngestionRequest,@ApiParam(value = "file detail") @Valid @RequestPart("file") MultipartFile facilitiesFile) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<DHIS2IngestionResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"jobId\" : \"\",  \"eventId\" : \"eventId\",  \"tenantId\" : \"tenantA\"}", DHIS2IngestionResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<DHIS2IngestionResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<DHIS2IngestionResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/v1/dhis2/household/ingest", method = RequestMethod.POST)
                public ResponseEntity<DHIS2IngestionResponse> v1Dhis2HouseholdIngestPost(@ApiParam(value = "Details for ingesting household registry data for sepcific tenantId" ,required=true )  @Valid @RequestBody DHIS2IngestionRequest dhIS2IngestionRequest) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<DHIS2IngestionResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"jobId\" : \"\",  \"eventId\" : \"eventId\",  \"tenantId\" : \"tenantA\"}", DHIS2IngestionResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<DHIS2IngestionResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<DHIS2IngestionResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/v1/dhis2/inventory/ingest", method = RequestMethod.POST)
                public ResponseEntity<DHIS2IngestionResponse> v1Dhis2InventoryIngestPost(@ApiParam(value = "Details for ingesting inventory data for sepcific tenantId" ,required=true )  @Valid @RequestBody DHIS2IngestionRequest dhIS2IngestionRequest) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<DHIS2IngestionResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"jobId\" : \"\",  \"eventId\" : \"eventId\",  \"tenantId\" : \"tenantA\"}", DHIS2IngestionResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<DHIS2IngestionResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<DHIS2IngestionResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/v1/dhis2/OU/ingest", method = RequestMethod.POST)
                public ResponseEntity<DHIS2IngestionResponse> v1Dhis2OUIngestPost(@ApiParam(value = "Details for ingesting OU data for sepcific tenantId" ,required=true )  @Valid @RequestBody DHIS2IngestionRequest dhIS2IngestionRequest) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<DHIS2IngestionResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"jobId\" : \"\",  \"eventId\" : \"eventId\",  \"tenantId\" : \"tenantA\"}", DHIS2IngestionResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<DHIS2IngestionResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<DHIS2IngestionResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/v1/dhis2/supervisors/responses/ingest", method = RequestMethod.POST)
                public ResponseEntity<DHIS2IngestionResponse> v1Dhis2SupervisorsResponsesIngestPost(@ApiParam(value = "Details for ingesting supervisor response data for sepcific tenantId" ,required=true )  @Valid @RequestBody DHIS2IngestionRequest dhIS2IngestionRequest) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<DHIS2IngestionResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"jobId\" : \"\",  \"eventId\" : \"eventId\",  \"tenantId\" : \"tenantA\"}", DHIS2IngestionResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<DHIS2IngestionResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<DHIS2IngestionResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/v1/dhis2/users/ingest", method = RequestMethod.POST)
                public ResponseEntity<DHIS2IngestionResponse> v1Dhis2UsersIngestPost(@ApiParam(value = "Details for ingesting user data for sepcific tenantId" ,required=true )  @Valid @RequestBody DHIS2IngestionRequest dhIS2IngestionRequest) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<DHIS2IngestionResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"jobId\" : \"\",  \"eventId\" : \"eventId\",  \"tenantId\" : \"tenantA\"}", DHIS2IngestionResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<DHIS2IngestionResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<DHIS2IngestionResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/v1/job/_create", method = RequestMethod.POST)
                public ResponseEntity<DHIS2IngestionResponse> v1JobCreatePost(@ApiParam(value = "Descriptive name of the job entry." ,required=true )  @Valid @RequestBody JobRequest job,@ApiParam(value = "Client can specify if the resource in request body needs to be sent back in the response. This is being used to limit amount of data that needs to flow back from the server to the client in low bandwidth scenarios. Server will always send the server generated id for validated requests.", defaultValue = "true") @Valid @RequestParam(value = "echoResource", required = false, defaultValue="true") Boolean echoResource) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<DHIS2IngestionResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"jobId\" : \"\",  \"eventId\" : \"eventId\",  \"tenantId\" : \"tenantA\"}", DHIS2IngestionResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<DHIS2IngestionResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<DHIS2IngestionResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/v1/job/_delete", method = RequestMethod.DELETE)
                public ResponseEntity<JobRequest> v1JobDeleteDelete(@ApiParam(value = "delete criteria for the removal of a job" ,required=true )  @Valid @RequestBody JobRequest job,@ApiParam(value = "Client can specify if the resource in request body needs to be sent back in the response. This is being used to limit amount of data that needs to flow back from the server to the client in low bandwidth scenarios. Server will always send the server generated id for validated requests.", defaultValue = "true") @Valid @RequestParam(value = "echoResource", required = false, defaultValue="true") Boolean echoResource) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<JobRequest>(objectMapper.readValue("{  \"ExecutionRetryCount\" : \"ExecutionRetryCount\",  \"name\" : \"name\",  \"id\" : { },  \"type\" : \"type\",  \"status\" : \"status\"}", JobRequest.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<JobRequest>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<JobRequest>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/v1/job/_search", method = RequestMethod.GET)
                public ResponseEntity<JobResponse> v1JobSearchGet(@Size(min=2,max=128) @ApiParam(value = "Unique Identifier of ULB") @Valid @RequestParam(value = "jobId", required = false) String jobId) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<JobResponse>(objectMapper.readValue("{  \"ExecutionRetryCount\" : \"ExecutionRetryCount\",  \"ExecutionCompletionTime\" : \"ExecutionCompletionTime\",  \"name\" : \"name\",  \"executionStartTime\" : \"executionStartTime\",  \"id\" : { },  \"type\" : \"type\",  \"status\" : \"status\"}", JobResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<JobResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<JobResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/v1/job/_update", method = RequestMethod.PUT)
                public ResponseEntity<JobRequest> v1JobUpdatePut(@ApiParam(value = "Job details for updating the job" ,required=true )  @Valid @RequestBody JobRequest job,@ApiParam(value = "Client can specify if the resource in request body needs to be sent back in the response. This is being used to limit amount of data that needs to flow back from the server to the client in low bandwidth scenarios. Server will always send the server generated id for validated requests.", defaultValue = "true") @Valid @RequestParam(value = "echoResource", required = false, defaultValue="true") Boolean echoResource) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<JobRequest>(objectMapper.readValue("{  \"ExecutionRetryCount\" : \"ExecutionRetryCount\",  \"name\" : \"name\",  \"id\" : { },  \"type\" : \"type\",  \"status\" : \"status\"}", JobRequest.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<JobRequest>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<JobRequest>(HttpStatus.NOT_IMPLEMENTED);
                }

        }
