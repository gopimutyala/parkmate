package com.mouritech.parkmate.repository;

import com.mouritech.parkmate.entity.ClientImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientImageRepository extends JpaRepository<ClientImage, UUID> {

    List<ClientImage> findByClientClientId(UUID id);
}
