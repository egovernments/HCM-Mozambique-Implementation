package hcm.moz.impl.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.egov.tracer.config.TracerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Component
@Data
@Import({TracerConfiguration.class})
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DHIS2Configuration {

    @Value("${app.timezone}")
    private String timeZone;

    @PostConstruct
    public void initialize() {
        TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
    }

    @Bean
    @Autowired
    public MappingJackson2HttpMessageConverter jacksonConverter(ObjectMapper objectMapper) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        return converter;
    }

    // User Config
    @Value("${egov.user.host}")
    private String userHost;

    @Value("${egov.user.context.path}")
    private String userContextPath;

    @Value("${egov.user.create.path}")
    private String userCreateEndpoint;

    @Value("${egov.user.search.path}")
    private String userSearchEndpoint;

    @Value("${egov.user.update.path}")
    private String userUpdateEndpoint;

    @Value("${is.workflow.enabled}")
    private Boolean isWorkflowEnabled;


    // BTR Variables

    @Value("${dhis2.record.kafka.create.topic}")
    private String createTopic;

    @Value("${dhis2.record.kafka.update.topic}")
    private String updateTopic;

    @Value("${dhis2.record.default.offset}")
    private Integer defaultOffset;

    @Value("${dhis2.record.default.limit}")
    private Integer defaultLimit;

    @Value("${dhis2.record.search.max.limit}")
    private Integer maxLimit;

    @Value("${dhis2.job.kafka.create.topic}")
    private String createJobTopic;

    @Value("${dhis2.job.kafka.update.topic}")
    private String updateJobTopic;

    @Value("${dhis2.job.default.offset}")
    private Integer defaultJobOffset;

    @Value("${dhis2.job.default.limit}")
    private Integer defaultJobLimit;

    @Value("${dhis2.job.search.max.limit}")
    private Integer maxJobLimit;


    //MDMS
    @Value("${egov.mdms.host}")
    private String mdmsHost;

    @Value("${egov.mdms.search.endpoint}")
    private String mdmsEndPoint;

    //HRMS
    @Value("${egov.hrms.host}")
    private String hrmsHost;

    @Value("${egov.hrms.search.endpoint}")
    private String hrmsEndPoint;

    @Value("${egov.url.shortner.host}")
    private String urlShortnerHost;

    @Value("${egov.url.shortner.endpoint}")
    private String urlShortnerEndpoint;

    @Value("${egov.sms.notification.topic}")
    private String smsNotificationTopic;

}
