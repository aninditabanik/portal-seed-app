package com.portal.seed.elevate.repo;

import com.portal.seed.elevate.model.MerchantAssociationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElevateRepository extends JpaRepository<MerchantAssociationEntity, String> {
    Optional<MerchantAssociationEntity> findById(String id);

    @Query("select m from MerchantAssociationEntity m where m.orgId = ?1")
    MerchantAssociationEntity findByOrgId(String orgId);
}

