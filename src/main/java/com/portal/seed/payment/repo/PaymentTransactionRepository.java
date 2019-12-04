package com.portal.seed.payment.repo;

import com.portal.seed.payment.model.MerchantEntity;
import com.portal.seed.payment.model.PaymentTxnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTxnEntity, UUID> {

}
