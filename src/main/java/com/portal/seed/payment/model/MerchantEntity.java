package com.portal.seed.payment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "merchant", schema = "payments")
public class MerchantEntity {

    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "created_by")
    private UUID createdBy = UUID.fromString("cd86ff2e-fa0f-4bbc-92dd-0f0fde10e8cf");
    public UUID getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "modified_by")
    private UUID modifiedBy = UUID.fromString("cd86ff2e-fa0f-4bbc-92dd-0f0fde10e8cf");
    public UUID getModifiedBy() {
        return modifiedBy;
    }
    public void setModifiedBy(UUID modifiedBy) {
        this.modifiedBy = modifiedBy;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt = new Date();
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    @LastModifiedDate
    private Date modifiedAt = new Date();
    public Date getModifiedAt() {
        return modifiedAt;
    }
    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }


    @Column(name = "channel_created_by")
    private String channelCreatedBy = "abcd";
    public String getChannelCreatedBy() {
        return channelCreatedBy;
    }
    public void setChannelCreatedBy(String channelCreatedBy) {
        this.channelCreatedBy = channelCreatedBy;
    }


    @Column(name = "channel_modified_by")
    private String channelModifiedBy = "abcd";
    public String getChannelModifiedBy() {
        return channelModifiedBy;
    }
    public void setChannelModifiedBy(String channelModifiedBy) {
        this.channelModifiedBy = channelModifiedBy;
    }


    @Column(name = "name")
    private String name = "Anindita";
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "version")
    private Long version = 1L;
    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }

    @Column(name = "default_merchant_gateway_configuration_name", nullable = false, length = 1000)
    private String defaultMerchantGatewayConfigurationName;
    public String getDefaultMerchantGatewayConfigurationName() {
        return defaultMerchantGatewayConfigurationName;
    }
    public void setDefaultMerchantGatewayConfigurationName(String defaultMerchantGatewayConfigurationName) {
        this.defaultMerchantGatewayConfigurationName = defaultMerchantGatewayConfigurationName;
    }


}