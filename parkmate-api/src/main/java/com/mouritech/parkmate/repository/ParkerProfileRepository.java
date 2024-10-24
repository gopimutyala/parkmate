package com.mouritech.parkmate.repository;

import com.mouritech.parkmate.entity.ParkerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ParkerProfileRepository extends JpaRepository<ParkerProfile, UUID> {

    List<ParkerProfile> findByClientClientId(UUID id);

    List<ParkerProfile> findByOrganizationOrganizationId(UUID id);
}
