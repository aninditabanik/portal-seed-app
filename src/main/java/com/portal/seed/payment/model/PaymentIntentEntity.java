package com.portal.seed.payment.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "payment_intent", schema = "payments")
public class PaymentIntentEntity extends AuditableEntity implements java.io.Serializable {

//    static final Set<Status> TERMINAL_STATUSES =
//            new HashSet<Status>(Arrays.asList(Status.Canceled, Status.Captured, Status.Declined, Status.NonRetryableError));
    static final String REASON_BREAK = ".  ";

    @Column(name = "merchant_id")
    private UUID merchant;

    @Column(name = "payment_schedule_id")
    private UUID paymentSchedule;

    @Column(name = "payment_source_token_id")
    private UUID paymentSourceToken;

//    @OneToOne(mappedBy = "paymentIntent", cascade = CascadeType.ALL)
//    private PaymentTxnEntity resultingTxn;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "currency_code", nullable = false, length = 200)
    private String currencyCode;

    @Column(name = "amount", nullable = false, precision = 40, scale = 10)
    private Integer amount;

   // @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 200)
    private String status;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "payment_date", nullable = false, length = 13)
    private LocalDate paymentDate;

    //@Setter(AccessLevel.NONE)
    @Column(name = "payment_dated_at", nullable = false, length = 13)
    private Instant paymentDatedAt;

    @Column(name = "salesforce_platform_fee_factor", nullable = false, precision = 10, scale = 10)
    private BigDecimal salesforcePlatformFeeFactor;

    @Column(name = "statement_descriptor", length = 1000)
    private String statementDescriptor;

    @Column(name = "campaign_code", length = 1000)
    private String campaignCode;

    @Column(name = "source_code", length = 1000)
    private String sourceCode;

    @Column(name = "gateway_status", length = 1000)
    private String gatewayStatus;

    @Column(name = "gateway_decline_code", length = 1000)
    private String gatewayDeclineCode;

    @Column(name = "error_gateway_detail", length = 90000)
    private String errorGatewayDetail;

    @Column(name = "error_technical_detail", length = 90000)
    private String errorTechnicalDetail;

//    @EqualsAndHashCode.Exclude
//    @OneToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "metadata_id")
//    private ClientMetadataEntity metadata;

    public void assignMerchantPaymentDate(ZoneId merchantZoneId) {
        this.paymentDatedAt = Instant.now();
        this.paymentDate = LocalDateTime.ofInstant(paymentDatedAt, merchantZoneId).toLocalDate();
    }

//    public PaymentIntentEntity addRetryableError(String reason) {
//        setStatus(Status.RetryableError);
//        if (errorTechnicalDetail == null)
//            errorTechnicalDetail = "";
//        errorTechnicalDetail += reason + REASON_BREAK;
//        return this;
//    }

    public PaymentIntentEntity() {}

    public PaymentIntentEntity(
            UUID id,
            UUID merchant,
            String transactionType,
            String currencyCode,
            Integer amount,
            String status,
            BigDecimal salesforcePlatformFeeFactor,
            String statementDescriptor) {
        this.id = id;
        this.merchant = merchant;
        this.transactionType = transactionType;
        this.currencyCode = currencyCode;
        this.amount = amount;
        this.status = status;
        this.salesforcePlatformFeeFactor = salesforcePlatformFeeFactor;
        this.statementDescriptor = statementDescriptor;
    }

    public PaymentIntentEntity(
            UUID id,
            UUID merchant,
            UUID paymentSchedule,
            UUID paymentSourceToken,
            PaymentTxnEntity resultingTxn,
            String transactionType,
            String currencyCode,
            Integer amount,
            String status,
            BigDecimal salesforcePlatformFeeFactor,
            String statementDescriptor,
            String campaignCode,
            String sourceCode,
            String gatewayStatus,
            String gatewayDeclineCode,
            String errorGatewayDetail,
            String errorTechnicalDetail) {
        this.id = id;
        this.merchant = merchant;
        this.paymentSchedule = paymentSchedule;
        this.paymentSourceToken = paymentSourceToken;
        this.transactionType = transactionType;
        this.currencyCode = currencyCode;
        this.amount = amount;
        this.status = status;
        this.salesforcePlatformFeeFactor = salesforcePlatformFeeFactor;
        this.statementDescriptor = statementDescriptor;
        this.campaignCode = campaignCode;
        this.sourceCode = sourceCode;
        this.gatewayStatus = gatewayStatus;
        this.gatewayDeclineCode = gatewayDeclineCode;
        this.errorGatewayDetail = errorGatewayDetail;
        this.errorTechnicalDetail = errorTechnicalDetail;
    }
}

