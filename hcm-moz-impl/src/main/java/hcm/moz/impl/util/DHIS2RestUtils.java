package hcm.moz.impl.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class DHIS2RestUtils {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${egov.dhis2.host.auth.key}")
    private String dhis2Creds;

    public ResponseEntity<String> get(String url, String payload, HttpMethod httpMethod) throws URISyntaxException {
        URI uri = new URI(url);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + dhis2Creds);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(payload, headers);
        return restTemplate.exchange(uri, httpMethod, requestEntity, String.class);
    }
}
