package hcm.moz.impl.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * This is acting ID token of the authenticated user on the server. Any value provided by the clients will be ignored and actual user based on authtoken will be used on the server.
 */
@ApiModel(description = "This is acting ID token of the authenticated user on the server. Any value provided by the clients will be ignored and actual user based on authtoken will be used on the server.")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2022-11-10T09:30:58.137+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User   {
    @JsonProperty("tenantId")
    private String tenantId = null;

    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("userName")
    private String userName = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("altContactNumber")
    private String altContactNumber = null;

    @JsonProperty("userType")
    private String userType = null;

    @JsonProperty("gender")
    private String gender = null;

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("salutation")
    private String salutation = null;

    @JsonProperty("pan")
    private String pan = null;

    @JsonProperty("aadhaarNumber")
    private String aadhaarNumber = null;

    @JsonProperty("mobileNumber")
    private String mobileNumber = null;

    @JsonProperty("emailId")
    private String emailId = null;

    @JsonProperty("roles")
    @Valid
    private List<Role> roles = new ArrayList<>();

    @JsonProperty("correspondenceCity")
    private String correspondenceCity = null;

    @JsonProperty("correspondencePincode")
    private String correspondencePincode = null;

    @JsonProperty("correspondenceAddress")
    private String correspondenceAddress = null;

    @JsonProperty("permanentAddress")
    private String permanentAddress = null;

    @JsonProperty("permanentCity")
    private String permanentCity = null;

    @JsonProperty("permanentPincode")
    private String permanentPincode = null;

    @JsonProperty("fatherOrHusbandName")
    private String fatherOrHusbandName = null;

    @JsonProperty("otpReference")
    private String otpReference = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("active")
    private Boolean active = null;

    @JsonProperty("locale")
    private String locale = null;

    @JsonProperty("signature")
    private String signature = null;

    @JsonProperty("accountLocked")
    private Boolean accountLocked = null;

    @JsonProperty("fatherOrSpouseName")
    private String fatherOrSpouseName = null;

    @JsonProperty("bloodGroup")
    private String bloodGroup = null;

    @JsonProperty("identificationMark")
    private String identificationMark = null;

    @JsonProperty("photo")
    private String photo = null;


    public User addRolesItem(Role rolesItem) {
        this.roles.add(rolesItem);
        return this;
    }

}
