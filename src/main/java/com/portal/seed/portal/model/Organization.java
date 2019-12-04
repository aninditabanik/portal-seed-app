package com.portal.seed.portal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "organization", schema = "abanik")
public class Organization {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false, updatable = false)
    @JsonFormat(pattern="MM/dd/yyyy")
    @CreatedDate
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    @JsonFormat(pattern="MM/dd/yyyy")
    @LastModifiedDate
    private Date modifiedAt = new Date();

    @Id
    @GeneratedValue(generator = "id_generator")
    @SequenceGenerator(
            name = "id_generator",
            sequenceName = "id_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "name")
    private String name="UNICEF";

    @Column(name = "street")
    private String street = "100th Ave";

    @Column(name = "city")
    private String city = "Bellevue";

    @Column(name = "state")
    private String state = "WA";

    @Column(name = "postal_code")
    private String postalCode = "98004";

    @Column(name = "country")
    private String country = "US";


    @Column(name = "default_language")
    private String defaultLanguage = "en_US";

    @Column(name = "default_currency")
    private String defaultCurrency = "USD";

    @Column(name = "default_welcome_email_for_sso_only")
    private String defaultWelcomeEmailForSsoOnly = "SEND";

    @Column(name = "sfid_account_id")
    private String sfidAccountId = "0010t00001KhsBDAAZ";

    @Column(name = "time_zone")
    private String timeZone = "America/Los_Angeles";

    @Column(name = "is_processor")
    private Boolean isProcessor = true;

    @Column(name = "is_workplace")
    private Boolean isWorkplace = true;

    @Column(name = "is_wamp")
    private Boolean isWamp = true;

    @Column(name = "is_reseller")
    private Boolean isReseller = true;


    @Column(name = "is_platform")
    private Boolean isPlatform = true;

    @Column(name = "is_united_way")
    private Boolean isUnitedWay = true;

    @Column(name = "is_single_signon_enabled")
    private Boolean isSingleSignonEnabled = false;

    @Column(name = "is_sso_welcome_email_disabled")
    private Boolean isSsoWelcomeEmailDisabled = false;

    @Column(name = "is_customer_support_partner")
    private Boolean isCustomerSupportPartner = false;

    @Column(name = "is_volunteering_social_visibility_active")
    private Boolean isVolunteeringSocialVisibilityActive = false;

    @Column(name = "created_by")
    private Integer createdBy =1000;

    @Column(name = "is_nonprofit")
    private Boolean isNonprofit = true;

}