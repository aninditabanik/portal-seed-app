package com.portal.seed.payment.model.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;

@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTxn extends Auditable {
    private ExpandableField<Merchant> merchant;
    private ExpandableField<PaymentIntent> paymentIntent;
    //private ExpandableField<PaymentSourceToken> paymentSourceToken;
    private PaymentTxn originalTxn;
    private String transactionType;
    private String currencyCode;
    private BigInteger amount;
    private LocalDate paymentDate;
    private Instant capturedAt;
    private BigInteger salesforcePlatformFeeAmount;
    private String permissionToPublish;
    private String statementDescriptor;
    private String campaignCode;
    private String sourceCode;
    private boolean adjustsOriginalTransaction;
    private String adjustmentType;
    private String adjustmentReason;
    private String adjustmentComments;
    private String customerVisibleTransactionNumber;

    @JsonIgnore
    public Merchant getMerchantObject() {
        return null == merchant ? null : merchant.getUnderlyingObject();
    }

    @JsonIgnore
    public PaymentIntent getPaymentIntentObject() {
        return null == paymentIntent ? null : paymentIntent.getUnderlyingObject();
    }
//
//    @JsonIgnore
//    public PaymentSourceToken getPaymentSourceTokenObject() {
//        return null == paymentSourceToken ? null : paymentSourceToken.getUnderlyingObject();
//    }
}
