package com.portal.seed.payment.model.api;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FullRefundRequest {
    private UUID merchantId;
    private UUID transactionId;
}
