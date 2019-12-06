package com.portal.seed.payment.model.api;

import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ToString
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auditable {

    public enum Channel {
        CRM,
        ENGAGEMENT_HUB,
        GIVING_FORMS,
        SFDO_INSIGHTS,
        SPC,
        WEBHOOK,
        WSAPI
    }

    protected UUID id;
    protected Instant createdAt;
    protected Instant modifiedAt;
}

