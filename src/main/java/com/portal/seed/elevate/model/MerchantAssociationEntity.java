package com.portal.seed.elevate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "merchant_association", schema = "portal_elevate")
public class MerchantAssociationEntity {

    @Column(name = "organization_id")
    private String orgId;

    @Id
    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "has_default_gateway")
    private Boolean hasDefaultGateway = true;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Boolean getHasDefaultGateway() {
        return hasDefaultGateway;
    }

    public void setHasDefaultGateway(Boolean hasDefaultGateway) {
        this.hasDefaultGateway = hasDefaultGateway;
    }

}
