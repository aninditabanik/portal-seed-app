package com.portal.seed.controller.request;

import com.portal.seed.controller.SeedController;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaymentRequestBuilder {

    List<CreatePaymentRequest> payments;

    static final String GATEWAY_ID = "f23da98a-c7aa-4637-962a-8c852e765e38";
    static final String PAYMENT_SOURCE_CONFIG_ID = "b1016af0-8b34-43b9-9e4d-940b4f53aeb3";
    static final String PAYMENT_SOURCE_TOKEN_ID = "98e11d34-4519-4668-b09d-85a3c6765989";


    public List<CreatePaymentRequest> getPayments(){
        payments = new ArrayList<>();
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 10000, "Payment", "captured", LocalDate.of(2018, 10, 31), true));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 94000, "Payment", "captured", LocalDate.of(2018, 12, 30), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 94000, "Payment", "authorized", LocalDate.of(2018, 12, 30), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 27000, "Payment", "captured", LocalDate.of(2019, 01, 10), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com",  1000, "Payment", "captured", LocalDate.of(2019, 02, 02), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 40300, "Payment", "declined", LocalDate.of(2019, 03, 15), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 678900, "Payment", "captured", LocalDate.of(2019, 04, 30), true));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 32000, "Payment", "captured", LocalDate.of(2019, 05, 15), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 1000000, "Payment", "captured", LocalDate.of(2019, 06, 11), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com",  600, "Payment", "pending", LocalDate.of(2019, 07, 24), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 100, "Payment", "captured", LocalDate.of(2019, 9, 23), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 6700, "Payment", "captured", LocalDate.of(2019, 9, 30), true));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 50500, "Payment", "pending", LocalDate.of(2019, 10, 20), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 40400, "Payment", "declined", LocalDate.of(2019, 10, 30), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 99900, "Payment", "canceled", LocalDate.of(2019, 10, 30), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com", 88800, "Payment", "error", LocalDate.of(2019, 10, 30), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com",  600, "Payment", "new", LocalDate.of(2019, 07, 02), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Barbara", "Rich", "BRich@email.com",  600, "Payment", "refunded", LocalDate.of(2019, 07, 02), false));

        payments.add(createRequest(SeedController.MERCHANT_ID,"Kevin", "Casanova", "KevinC@email.com", 1, "Payment", "captured", LocalDate.of(2018, 10, 31), true));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Kevin", "Casanova", "KevinC@email.com", 11, "Payment", "captured", LocalDate.of(2018, 12, 30), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Kevin", "Casanova", "KevinC@email.com", 99, "Payment", "captured", LocalDate.of(2019, 01, 10), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Kevin", "Casanova", "KevinC@email.com",  100, "Payment", "captured", LocalDate.of(2019, 02, 02), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Kevin", "Casanova", "KevinC@email.com", 499, "Payment", "declined", LocalDate.of(2019, 03, 15), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Kevin", "Casanova", "KevinC@email.com", 1097, "Payment", "captured", LocalDate.of(2019, 04, 30), true));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Kevin", "Casanova", "KevinC@email.com", 10098, "Payment", "pending", LocalDate.of(2019, 05, 15), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Kevin", "Casanova", "KevinC@email.com", 99999, "Payment", "declined", LocalDate.of(2019, 06, 11), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Kevin", "Casanova", "KevinC@email.com",  990, "Payment", "pending", LocalDate.of(2019, 07, 24), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Kevin", "Casanova", "KevinC@email.com", 40309, "Payment", "declined", LocalDate.of(2019, 9, 23), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Kevin", "Casanova", "KevinC@email.com", 12345, "Payment", "captured", LocalDate.of(2019, 9, 30), true));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Kevin", "Casanova", "KevinC@email.com", 5, "Payment", "captured", LocalDate.of(2019, 10, 20), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Kevin", "Casanova", "KevinC@email.com", 606, "Payment", "pending", LocalDate.of(2019, 10, 30), false));


        payments.add(createRequest(SeedController.MERCHANT_ID,"Linda", "Wilcox", "Linda.Wilcox@email.com", 10000, "Payment", "captured", LocalDate.of(2018, 10, 31), true));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Linda", "Wilcox", "Linda.Wilcox@email.com", 94000, "Payment", "captured", LocalDate.of(2018, 2, 28), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Linda", "Wilcox", "Linda.Wilcox@email.com", 27000, "Payment", "pending", LocalDate.of(2019, 03, 10), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Linda", "Wilcox", "Linda.Wilcox@email.com",  100, "Payment", "declined", LocalDate.of(2019, 04, 02), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Linda", "Wilcox", "Linda.Wilcox@email.com", 40300, "Payment", "declined", LocalDate.of(2019, 05, 15), true));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Linda", "Wilcox", "Linda.Wilcox@email.com", 678900, "Payment", "captured", LocalDate.of(2019, 06, 30), true));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Linda", "Wilcox", "Linda.Wilcox@email.com", 32000, "Payment", "pending", LocalDate.of(2019, 07, 15), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Linda", "Wilcox", "Linda.Wilcox@email.com", 1000000, "Payment", "declined", LocalDate.of(2019, 8, 11), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Linda", "Wilcox", "Linda.Wilcox@email.com",  990, "Payment", "captured", LocalDate.of(2019, 9, 24), false));

        payments.add(createRequest(SeedController.MERCHANT_ID,"Patricia", "Hooper", "PatriciaHooper@email.com",  10000, "Payment", "captured", LocalDate.of(2018, 1, 31), true));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Patricia", "Hooper", "PatriciaHooper@email.com",  94000, "Payment", "captured", LocalDate.of(2018, 2, 28), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Patricia", "Hooper", "PatriciaHooper@email.com",  27000, "Payment", "pending", LocalDate.of(2019, 3, 10), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Patricia", "Hooper", "PatriciaHooper@email.com",  1000, "Payment", "declined", LocalDate.of(2019, 4, 2), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Patricia", "Hooper", "PatriciaHooper@email.com",  40300, "Payment", "captured", LocalDate.of(2019, 5, 15), true));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Patricia", "Hooper", "PatriciaHooper@email.com",  678900, "Payment", "captured", LocalDate.of(2019, 6, 30), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Patricia", "Hooper", "PatriciaHooper@email.com",  32000, "Payment", "pending", LocalDate.of(2019, 7, 15), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Patricia", "Hooper", "PatriciaHooper@email.com",  1000000, "Payment", "declined", LocalDate.of(2019, 8, 11), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Patricia", "Hooper", "PatriciaHooper@email.com",  600, "Payment", "captured", LocalDate.of(2019, 7, 15), false));

        payments.add(createRequest(SeedController.MERCHANT_ID,"Sam", "Nelson", "NelsonS@email.com",  10000, "Payment", "captured", LocalDate.of(2019, 3, 15), true));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Sam", "Nelson", "NelsonS@email.com",  94000, "Payment", "captured", LocalDate.of(2019, 4, 30), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Sam", "Nelson", "NelsonS@email.com",  27000, "Payment", "pending", LocalDate.of(2019, 5, 15), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Sam", "Nelson", "NelsonS@email.com",  1000, "Payment", "declined", LocalDate.of(2019, 6, 11), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Sam", "Nelson", "NelsonS@email.com",  40300, "Payment", "captured", LocalDate.of(2019, 7, 24), true));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Sam", "Nelson", "NelsonS@email.com",  678900, "Payment", "captured", LocalDate.of(2019, 9, 23), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Sam", "Nelson", "NelsonS@email.com",  32000, "Payment", "pending", LocalDate.of(2019, 9, 30), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Sam", "Nelson", "NelsonS@email.com",  1000000, "Payment", "declined", LocalDate.of(2019, 10, 20), false));
        payments.add(createRequest(SeedController.MERCHANT_ID,"Sam", "Nelson", "NelsonS@email.com",  600, "Payment", "captured", LocalDate.of(2019, 10, 30), false));

        return payments;
    }

    private CreatePaymentRequest createRequest(String merchantId, String firstName, String lastName, String email,
                                               int amount, String transactionType, String status, LocalDate date, boolean isRefund) {
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
        in.setCreatedDate(date);
        in.setIsRefund(isRefund);
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
