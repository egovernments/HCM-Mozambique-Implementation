package hcm.moz.impl.util;

import org.hisp.dhis.Dhis2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;

@Component
public class DHIS2RestUtils {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${egov.dhis2.host.auth.key}")
    private String dhis2Creds;

    @Value("${egov.dhis2.host.username}")
    private String dhis2Username;

    @Value("${egov.dhis2.host.password}")
    private String dhis2Password;

    @Value("${egov.dhis2.host.url}")
    private String dhis2ServiceHostUrl;

    private Dhis2 dhis2;

    public ResponseEntity<String> get(String url, String payload, HttpMethod httpMethod) throws URISyntaxException {
        URI uri = new URI(url);
        HttpHeaders headers = new HttpHeaders();
        String valueToEncode = dhis2Username + ":" + dhis2Password;
        headers.add("Authorization", "Basic " +  Base64.getEncoder().encodeToString(valueToEncode.getBytes()));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(payload, headers);
        return restTemplate.exchange(uri, httpMethod, requestEntity, String.class);
    }

    public Dhis2 getDhis2() {
        if (this.dhis2 == null) {
            this.dhis2 = Dhis2.withBasicAuth(dhis2ServiceHostUrl, dhis2Username, dhis2Password);
        }
        return this.dhis2;
    }

}
