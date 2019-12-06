package com.portal.seed.payment.repo;

import com.portal.seed.payment.model.MerchantEntity;
import com.portal.seed.payment.model.PaymentTxnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
public interface PaymentTransactionRepository extends JpaRepository<PaymentTxnEntity, UUID> {

    @Modifying
    @Query("delete from PaymentTxnEntity pte where pte.merchant = ?1")
    void deleteByMerchant(UUID merchant);
}
