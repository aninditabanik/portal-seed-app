package com.portal.seed.payment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "payment_txn", schema = "payments")
public class PaymentTxnEntity extends AuditableEntity implements java.io.Serializable {

    @Column(name = "merchant_id")
    private UUID merchant;

    @Column(name = "payment_intent_id")
    private UUID paymentIntent;

    @Column(name = "payment_source_token_id")
    private UUID paymentSourceToken;

    @Column(name = "original_transaction_id")
    private UUID originalTxn;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "captured_at", nullable = false, length = 13)
    private Instant capturedAt;

    @Column(name = "salesforce_platform_fee_amount", nullable = false, precision = 40, scale = 10)
    private BigInteger salesforcePlatformFeeAmount;

    @Column(name = "permission_to_publish")
    private String permissionToPublish;

    @Column(name = "statement_descriptor", nullable = false, length = 1000)
    private String statementDescriptor;

    @Column(name = "campaign_code", length = 1000)
    private String campaignCode;

    @Column(name = "source_code", length = 1000)
    private String sourceCode;

    @Column(name = "adjusts_original_transaction", nullable = false)
    private boolean adjustsOriginalTransaction;

    @Column(name = "adjustment_type", length = 200)
    private String adjustmentType;

    @Column(name = "adjustment_reason", length = 200)
    private String adjustmentReason;

    @Column(name = "adjustment_comments", length = 30000)
    private String adjustmentComments;

    @Column(name = "customer_visible_transaction_number", length = 200)
    private String customerVisibleTransactionNumber;

    @Column(name = "gateway_transaction_number", length = 200)
    private String gatewayTransactionNumber;

    // TODO Need to add a gateway transaction number to this, since the above is what we communicate to the donor.

    /**
     * This constructor depends upon fetched references for the PaymentSourceToken and Merchant.
     *
     * capturedAt should be populated using the Charge.created timestamp and the capturedAmount should be
     * taken from the gateway response.
     */
//    public PaymentTxnEntity(
//            PaymentIntentEntity pie,
//            Integer capturedAmount,
//            Instant capturedAt,
//            String gatewayTransactionNumber) {
//        this.id = UUID.randomUUID();
//
//        this.paymentIntent = pie;
//        this.transactionType = pie.getTransactionType();
//        this.paymentSourceToken = pie.getPaymentSourceToken();
//        this.merchant = pie.getMerchant();
//        this.paymentDate = pie.getPaymentDate();
//        this.currencyCode = pie.getCurrencyCode();
//
//        this.amount = capturedAmount;
//        this.capturedAt = capturedAt;
//
//        // TODO Future Verification : is there a latform fee for refund or Credit?
////        if (transactionType == TransactionType.Payment) {
////            this.salesforcePlatformFeeAmount =
////                    new BigDecimal(capturedAmount).multiply(pie.getSalesforcePlatformFeeFactor());
////        }
//
//        this.customerVisibleTransactionNumber = defaultVisibleTxnNumber();
//        this.gatewayTransactionNumber = gatewayTransactionNumber;
//
//        this.statementDescriptor = pie.getStatementDescriptor() != null ? pie.getStatementDescriptor()
//                : this.merchant.getName() + " " + this.customerVisibleTransactionNumber;
//
//        // All payments will be "AskPermission" for now
//        this.permissionToPublish = PermissionToPublish.AskPermission;
//        // TODO verify whether the flag is correct for refund
//        this.adjustsOriginalTransaction = false;
//    }

    /*
     * Creates customer-visible txn numbers of the form nnnn-nnnn-nnnn-nnnn where n is hexadecimal.
     * Potentially a merchant's algorithm for their own customer-visible transaction numbers could be
     * customizable via a mechanism not yet designed.
     */
//    private String defaultVisibleTxnNumber() {
//        String[] idParts = UUID.randomUUID().toString().split("-", 0);
//        return Arrays.stream(idParts).limit(4).map(n -> n.substring(0, 4)).collect(Collectors.joining("-"));
//    }
}

