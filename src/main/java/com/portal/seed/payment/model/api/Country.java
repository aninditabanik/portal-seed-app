package com.portal.seed.payment.model.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Country {
    private String iso3;
    private String iso2;
    private String name;
    private short isoNum;
}

