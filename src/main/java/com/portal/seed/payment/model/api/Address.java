package com.portal.seed.payment.model.api;

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
public class Address extends Auditable {
    private Country country;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String briefpostalcode;
    private String fullpostalcode;
}
