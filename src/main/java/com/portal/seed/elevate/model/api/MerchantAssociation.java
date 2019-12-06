package com.portal.seed.elevate.model.api;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MerchantAssociation {
    private String organizationId;
    private String merchantId;
    private Boolean hasDefaultGateway;
}
