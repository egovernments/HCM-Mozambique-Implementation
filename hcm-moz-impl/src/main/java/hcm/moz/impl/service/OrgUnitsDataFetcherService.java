package hcm.moz.impl.service;



import com.fasterxml.jackson.databind.ObjectMapper;
import hcm.moz.impl.util.DHIS2RestUtils;
import org.hisp.dhis.Dhis2;
import org.hisp.dhis.Dhis2Config;
import org.hisp.dhis.model.OrgUnit;
import org.hisp.dhis.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrgUnitsDataFetcherService {

    public static final Logger logger = LoggerFactory.getLogger(OrgUnitsDataFetcherService.class);

    @Autowired
    private DHIS2RestUtils dhis2RestUtils;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${egov.dhis2.host.url}")
    private String dhis2ServiceHostUrl;

    @Value("${egov.dhis2.host.username}")
    private String dhis2Username;

    @Value("${egov.dhis2.host.password}")
    private String dhis2Password;

    public List<OrgUnit> fetchOrgUnits(int pageNo, int pageSize) {
        try {
            //TODO: Get host url by tenant from MDMS service
            Dhis2Config config = new Dhis2Config(
                    dhis2ServiceHostUrl,dhis2Username
                    , dhis2Password);

            Dhis2 dhis2 = new Dhis2(config);
            List<OrgUnit> orgUnits = dhis2.getOrgUnits(Query.instance()
                    .setPaging(1, 200));
            return orgUnits;
        } catch (Exception e) {
            logger.error("Failed while fetching Org Units data from dhis2 with error", e);
        }
        return new ArrayList<>();
    }


}
