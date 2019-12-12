package com.portal.seed.payment.repo;

import com.portal.seed.payment.model.PaymentIntentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Transactional
public interface PaymentIntentEntityRepository
        extends JpaRepository<PaymentIntentEntity, UUID> {

    @Modifying
    @Query("delete from PaymentIntentEntity pie where pie.merchant = ?1")
    void deleteByMerchant(UUID merchant);

    @Modifying
    @Query("update PaymentIntentEntity pie set pie.createdAt = :createdAt where pie.id = :id")
    int updatePayment(@Param("createdAt") LocalDate createdAt, @Param("id") UUID id);

    @Modifying
    @Query("update PaymentIntentEntity pie set pie.status = :status where pie.id = :id")
    int updatePaymentStatus(@Param("status") String status, @Param("id") UUID id);
}
