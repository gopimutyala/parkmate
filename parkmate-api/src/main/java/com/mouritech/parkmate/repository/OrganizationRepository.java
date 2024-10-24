package com.mouritech.parkmate.repository;

import com.mouritech.parkmate.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrganizationRepository extends JpaRepository<Organization, UUID> {

    List<Organization> findByClientClientId(UUID id);
}
