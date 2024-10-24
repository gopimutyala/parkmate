package com.mouritech.parkmate.repository;

import com.mouritech.parkmate.entity.ClientBranding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientBrandingRepository extends JpaRepository<ClientBranding, UUID> {

    List<ClientBranding> findByClientClientId(UUID id);
}
