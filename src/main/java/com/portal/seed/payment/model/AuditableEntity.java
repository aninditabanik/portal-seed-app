package com.portal.seed.payment.model;


import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
//import org.salesforce.payments.model.api.Auditable.Channel;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class AuditableEntity extends VersionedEntity {

    // This is just temporary until we wire in authentication
    private static final UUID ROOTUSER_ID = UUID.fromString("cd86ff2e-fa0f-4bbc-92dd-0f0fde10e8cf");

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    protected UUID id;

    @Column(name = "created_by", nullable = false)
    protected UUID createdById;

    @Column(name = "modified_by", nullable = false)
    protected UUID modifiedById;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    protected LocalDate createdAt;

    @Column(name = "modified_at")
    @UpdateTimestamp
    protected LocalDate modifiedAt;

    @Column(name = "remote_created_by", length = 1000)
    protected String remoteCreatedBy;

    @Column(name = "remote_modified_by", length = 1000)
    protected String remoteModifiedBy;

    @Column(name = "channel_created_by", nullable = false, length = 200)
    protected String channelCreatedBy;

    @Column(name = "channel_modified_by", nullable = false, length = 200)
    protected String channelModifiedBy;

    public AuditableEntity(UUID id) {
        setId(id);
    }

//    @PrePersist
//    protected void onCreate() {
//        // Set creation-time auditable attributes from api_user's login session.
//        // TODO These are all placeholder attributes until the authenticated ApiUser context is available
//        this.createdById = ROOTUSER_ID;
//        this.channelCreatedBy = Channel.GIVING_FORMS.toString();
//        // It's not necessary to update timestamps, which are controlled by other annotations
//
//        this.onUpdate();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        // Set update-time auditable attributes from api_user's login session.
//        // TODO These are all placeholder attributes until the authenticated ApiUser context is available
//        this.modifiedById = ROOTUSER_ID;
//        this.channelModifiedBy = Channel.GIVING_FORMS.toString();
//        // It's not necessary to update timestamps, which are controlled by other annotations
//    }
}

