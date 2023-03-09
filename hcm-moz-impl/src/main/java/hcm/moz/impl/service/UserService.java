package hcm.moz.impl.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import digit.models.coremodels.UserDetailResponse;
import hcm.moz.impl.config.DHIS2Configuration;
import hcm.moz.impl.util.UserUtil;
import hcm.moz.impl.web.models.CreateUserRequest;
import hcm.moz.impl.web.models.Role;
import hcm.moz.impl.web.models.User;
import org.egov.common.contract.request.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Service
public class UserService {
    private UserUtil userUtils;

    private DHIS2Configuration config;

    @Autowired
    public UserService(UserUtil userUtils, DHIS2Configuration config) {
        this.userUtils = userUtils;
        this.config = config;
    }

    /**
     * Calls user service to enrich user from search or upsert user
     * @param fetchedUsersJsonNode
     */
    public List<User> mapToDigitUsers(JsonNode fetchedUsersJsonNode) {
        List<User> digitusers = new ArrayList<>();
        if (fetchedUsersJsonNode.get("users").isArray()) {
            fetchedUsersJsonNode.get("users").forEach(userJsonNode -> {
                User user = User.builder().userName(userJsonNode.get("userCredentials").get("username").asText())
                        .name(userJsonNode.get("name").asText())
                        .active(true)
                        .roles(extractRoles(userJsonNode))
                        .build();
                digitusers.add(user);
            });
        }
        return digitusers;
    }

    private List<Role> extractRoles(JsonNode userJsonNode) {
        List<Role> digitRoles = new ArrayList<>();
        JsonNode roles = userJsonNode.get("userCredentials").get("userRoles");
        if (roles != null && roles.isArray()) {
            roles.forEach(role -> {
                if (role != null) {
                    Role digitRole = new Role();
                    digitRole.setName(role.asText());
                    digitRole.setCode(role.asText().toUpperCase(Locale.ROOT));
                    digitRoles.add(digitRole);
                }
            });
        }
        return digitRoles;
    }

    /**
     * Creates the user from the given userInfo by calling user service
     * @param requestInfo
     * @param tenantId
     * @param userInfo
     * @return
     */
    private User createUser(RequestInfo requestInfo, String tenantId, User userInfo) {
        StringBuilder uri = new StringBuilder(config.getUserHost())
                .append(config.getUserContextPath())
                .append(config.getUserCreateEndpoint());


        UserDetailResponse userDetailResponse = userUtils.userCall(new CreateUserRequest(requestInfo, userInfo), uri);
        //return userDetailResponse.getUser().get(0);
        //TODO: Finish users save part
        return null;

    }

}