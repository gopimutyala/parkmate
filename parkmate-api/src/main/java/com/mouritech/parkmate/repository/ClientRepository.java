package com.mouritech.parkmate.repository;

import com.mouritech.parkmate.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

}
