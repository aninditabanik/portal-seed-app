package com.portal.seed.payment.model.api;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Merchant extends Auditable {
    private Address billingAddress;
    private String defaultMerchantGatewayConfigurationName;

    private String name;

    public Merchant(UUID id) {
        this.id = id;
    }
}
