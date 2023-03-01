package hcm.moz.impl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.POJONode;
import hcm.moz.impl.util.DHIS2RestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

@Component
public class UsersDataFetcherService {

    public static final Logger logger = LoggerFactory.getLogger(UsersDataFetcherService.class);

    @Autowired
    private DHIS2RestUtils dhis2RestUtils;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${egov.dhis2.host.url}")
    private String dhis2ServiceHostUrl;

    @Value("${egov.dhis2.users.endpoint}")
    private String dhis2UsersEndpoint;

    @Value("${egov.dhis2.users.fields}")
    private String dhis2UsersFields;

    public JsonNode fetch(int pageNo, int pageSize) {
        try {
            //TODO: Get host url by tenant from MDMS service
            String baseUrl = dhis2ServiceHostUrl + dhis2UsersEndpoint;
            baseUrl = baseUrl + "?page=" + pageNo + "&pageSize="+ pageSize + "&fields=" + dhis2UsersFields;
            ResponseEntity<String> response = dhis2RestUtils.get(baseUrl,null, HttpMethod.GET);
            String users = response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(users);
        } catch (URISyntaxException | JsonProcessingException e) {
            logger.error("Failed while fetching users data from dhis2 with error", e);
        }
        return new POJONode(null);
    }


}


