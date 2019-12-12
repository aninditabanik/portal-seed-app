package com.portal.seed.controller.request;

import jdk.vm.ci.meta.Local;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePaymentRequest {
    private BigInteger amount;
    private String currencyCode;
    private UUID merchantId;
    private String email;
    private String firstName;
    private String lastName;
    private UUID paymentSourceTokenId;
    private String gatewayPaymentSourceToken;
    private UUID gatewayId;
    private UUID paymentSourceConfigId;
    private String transactionType;
    private String status;
    private LocalDate createdDate;
    private Boolean isRefund;

//    public CreatePaymentRequest(Integer amount, String currencyCode, UUID merchantId, String email,
//                                String firstName, String lastName, UUID paymentSourceTokenId, String gatewayPaymentSourceToken,
//                                UUID gatewayId, UUID paymentSourceConfigId) {
//        this.amount = amount;
//        this.currencyCode = currencyCode;
//        this.merchantId = merchantId;
//        this.email = email;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.paymentSourceTokenId = paymentSourceTokenId;
//        this.gatewayPaymentSourceToken = gatewayPaymentSourceToken;
//        this.gatewayId = gatewayId;
//        this.paymentSourceConfigId = paymentSourceConfigId;
//    }
}
