package hcm.moz.impl.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hcm.moz.impl.constants.DHIS2FormEnums;
import hcm.moz.impl.util.DHIS2RestUtils;
import org.hisp.dhis.model.Program;
import org.hisp.dhis.model.event.Event;
import org.hisp.dhis.query.Filter;
import org.hisp.dhis.query.Query;
import org.hisp.dhis.query.event.EventsQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StocksDataFetcherService {

    public static final Logger logger = LoggerFactory.getLogger(StocksDataFetcherService.class);

    @Autowired
    private DHIS2RestUtils dhis2RestUtils;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${egov.dhis2.host.url}")
    private String dhis2ServiceHostUrl;

    @Value("${egov.dhis2.programs.endpoint}")
    private String dhis2ProgramsEndpoint;

    @Value("${egov.dhis2.events.endpoint}")
    private String dhis2EventsEndpoint;

    public List<Event> fetchStocks(int pageNo, int pageSize) {
        List<Event> events = new ArrayList<>();
        Query programQuery = Query.instance();
        programQuery.addFilter(Filter.in("name",
                Arrays.stream(DHIS2FormEnums.values()).map(DHIS2FormEnums::getName).collect(Collectors.toList())
        )).setPaging( pageNo, pageSize ) ;
        List<Program> programList = dhis2RestUtils.getDhis2().getPrograms(programQuery);
        programList.forEach(program -> {
            EventsQuery eventsQuery = EventsQuery.instance();
            eventsQuery.setProgram(program.getId());
            events.addAll(dhis2RestUtils.getDhis2().getEvents(eventsQuery).getInstances());
        });
        return events;
    }

}


