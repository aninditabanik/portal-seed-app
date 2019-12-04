package com.portal.seed.payment.model.api;

import lombok.*;

import java.time.Instant;
import java.util.UUID;

@ToString(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Merchant{
    private String billingAddress;
    private String defaultMerchantGatewayConfigurationName;

    private String name;
    private UUID id;
    private Instant createdAt;
    private Instant modifiedAt;

    public Merchant(UUID id) {
        this.id = id;
    }
}
