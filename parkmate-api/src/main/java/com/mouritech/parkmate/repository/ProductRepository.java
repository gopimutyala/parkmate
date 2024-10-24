package com.mouritech.parkmate.repository;

import com.mouritech.parkmate.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findByClientClientId(UUID id);
}
