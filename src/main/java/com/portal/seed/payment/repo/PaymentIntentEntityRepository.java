package com.portal.seed.payment.repo;

import com.portal.seed.payment.model.PaymentIntentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
public interface PaymentIntentEntityRepository
        extends JpaRepository<PaymentIntentEntity, UUID> {

    @Modifying
    @Query("delete from PaymentIntentEntity pie where pie.merchant = ?1")
    void deleteByMerchant(UUID merchant);
}
