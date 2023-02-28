package hcm.moz.impl.web.controllers;

import hcm.moz.impl.web.models.DHIS2IngestionRequest;
import hcm.moz.impl.web.models.DHIS2IngestionResponse;
import hcm.moz.impl.web.models.ErrorRes;
import hcm.moz.impl.web.models.JobRequest;
import hcm.moz.impl.web.models.JobResponse;
import org.springframework.core.io.Resource;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import hcm.moz.impl.TestConfiguration;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
* API tests for V1ApiController
*/
@Ignore
@RunWith(SpringRunner.class)
@WebMvcTest(V1ApiController.class)
@Import(TestConfiguration.class)
public class V1ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void v1Dhis2FacilitiesIngestPostSuccess() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/dhis2/facilities/ingest").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void v1Dhis2FacilitiesIngestPostFailure() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/dhis2/facilities/ingest").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void v1Dhis2HouseholdIngestPostSuccess() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/dhis2/household/ingest").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void v1Dhis2HouseholdIngestPostFailure() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/dhis2/household/ingest").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void v1Dhis2InventoryIngestPostSuccess() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/dhis2/inventory/ingest").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void v1Dhis2InventoryIngestPostFailure() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/dhis2/inventory/ingest").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void v1Dhis2OUIngestPostSuccess() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/dhis2/OU/ingest").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void v1Dhis2OUIngestPostFailure() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/dhis2/OU/ingest").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void v1Dhis2SupervisorsResponsesIngestPostSuccess() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/dhis2/supervisors/responses/ingest").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void v1Dhis2SupervisorsResponsesIngestPostFailure() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/dhis2/supervisors/responses/ingest").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void v1Dhis2UsersIngestPostSuccess() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/dhis2/users/ingest").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void v1Dhis2UsersIngestPostFailure() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/dhis2/users/ingest").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void v1JobCreatePostSuccess() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/job/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void v1JobCreatePostFailure() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/job/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void v1JobDeleteDeleteSuccess() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/job/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void v1JobDeleteDeleteFailure() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/job/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void v1JobSearchGetSuccess() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/job/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void v1JobSearchGetFailure() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/job/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void v1JobUpdatePutSuccess() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/job/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void v1JobUpdatePutFailure() throws Exception {
        mockMvc.perform(post("/hcm-moz-impl-services/v1/job/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

}
