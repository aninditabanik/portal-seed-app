package com.portal.seed.payment.repo;

import com.portal.seed.payment.model.PaymentIntentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentIntentEntityRepository
        extends JpaRepository<PaymentIntentEntity, UUID> {

}
