package com.portal.seed.portal.repo;

import com.portal.seed.portal.model.Organization;
import com.portal.seed.portal.model.UserRoleOrgAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleOrgRepository extends JpaRepository<UserRoleOrgAssociation, Long> {
    Optional<UserRoleOrgAssociation> findById(Long id);
}
