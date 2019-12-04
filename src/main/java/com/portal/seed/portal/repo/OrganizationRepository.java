package com.portal.seed.portal.repo;

import com.portal.seed.portal.model.Organization;
import com.portal.seed.portal.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findById(Long id);
}