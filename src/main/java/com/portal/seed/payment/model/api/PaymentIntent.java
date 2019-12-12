package com.portal.seed.payment.model.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Slf4j
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentIntent extends Auditable {

    private ExpandableField<Merchant> merchant;
    private String transactionType;
    private String currencyCode;
    private BigInteger amount;
    private String status;
    private LocalDate paymentDate;
    private BigDecimal salesforcePlatformFeeFactor;
    private String statementDescriptor;
    private String campaignCode;
    private String sourceCode;
    private String gatewayStatus;
    private String gatewayDeclineCode;
    private String errorGatewayDetail;
    private String errorTechnicalDetail;
    private String email;
    private String firstName;
    private String lastName;
    private PaymentTxn resultingTxn;
    @EqualsAndHashCode.Exclude
    private JsonNode metadata;

    @JsonIgnore
    public Merchant getMerchantObject() {
        return null == merchant ? null : merchant.getUnderlyingObject();
    }
}

