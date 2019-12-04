package com.portal.seed.elevate.repo;

import com.portal.seed.elevate.model.MerchantAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElevateRepository extends JpaRepository<MerchantAssociation, String> {
    Optional<MerchantAssociation> findById(String id);
}

