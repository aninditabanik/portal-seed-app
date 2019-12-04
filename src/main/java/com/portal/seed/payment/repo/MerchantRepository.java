package com.portal.seed.payment.repo;

import com.portal.seed.payment.model.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity, UUID> {
    Optional<MerchantEntity> findById(UUID id);
}


