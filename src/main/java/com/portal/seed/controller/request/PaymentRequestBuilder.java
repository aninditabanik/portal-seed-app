package com.portal.seed.controller.request;

import com.portal.seed.controller.SeedController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaymentRequestBuilder {

    List<CreatePaymentRequest> payments = new ArrayList<>();

    static final String GATEWAY_ID = "f23da98a-c7aa-4637-962a-8c852e765e38";
    static final String PAYMENT_SOURCE_CONFIG_ID = "b1016af0-8b34-43b9-9e4d-940b4f53aeb3";
    static final String PAYMENT_SOURCE_TOKEN_ID = "98e11d34-4519-4668-b09d-85a3c6765989";
    

    public List<CreatePaymentRequest> getPayments(){
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 10000, "Payment", "captured"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 10000, "Refund", "refunded"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 94000, "Payment", "captured"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 27000, "Payment", "captured"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com",  1000, "Payment", "captured"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 40300, "Payment", "canceled"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 678900, "Payment", "captured"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 32000, "Payment", "captured"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 1000000, "Payment", "captured"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 100, "Payment", "captured"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com",  6700, "Payment", "captured"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 6700, "Refund", "refunded"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 50500, "Payment", "pending"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 40400, "Payment", "canceled"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 678900, "Refund", "refunded"));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 1000000, "Payment", "pending"));
        return payments;
    }

    private CreatePaymentRequest createRequest(String merchantId, String firstName, String lastName, String email,
                                               int amount, String transactionType, String status) {
        CreatePaymentRequest in = new CreatePaymentRequest();
        in.setMerchantId(UUID.fromString(merchantId));
        in.setFirstName(firstName);
        in.setLastName(lastName);
        in.setEmail(email);
        in.setTransactionType(transactionType);
        in.setStatus(status);
        in.setAmount(BigInteger.valueOf(amount));
        in.setCurrencyCode("USD");
        in.setGatewayId(UUID.fromString("f23da98a-c7aa-4637-962a-8c852e765e38"));
        in.setPaymentSourceConfigId(UUID.fromString("b1016af0-8b34-43b9-9e4d-940b4f53aeb3"));
        in.setPaymentSourceTokenId(UUID.fromString("98e11d34-4519-4668-b09d-85a3c6765989"));
        return in;
    }

    public CreatePaymentRequest makeRequest() {
        CreatePaymentRequest in = new CreatePaymentRequest();
        in.setAmount(BigInteger.TEN);
        in.setCurrencyCode("USD");
        in.setFirstName("SeedUserFirstName");
        in.setLastName("SeedUserLastName");
        in.setEmail("seed.user@portal.com");
        in.setGatewayId(UUID.fromString("f23da98a-c7aa-4637-962a-8c852e765e38"));
        in.setGatewayPaymentSourceToken("tok_visa");
        in.setMerchantId(UUID.fromString("47b70ca4-0f6e-4c52-819f-667ae804f9d2"));
        //in.setMerchantId(merchantId);
        in.setPaymentSourceConfigId(UUID.fromString("b1016af0-8b34-43b9-9e4d-940b4f53aeb3"));
        in.setPaymentSourceTokenId(UUID.fromString("98e11d34-4519-4668-b09d-85a3c6765989"));
        return in;
    }
}
