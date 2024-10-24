package com.mouritech.parkmate.entity;

import com.mouritech.parkmate.dto.BillingFrequency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "product_id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID productId;
    private int active;

    @Enumerated(EnumType.STRING)
    private BillingFrequency billingFrequency;

    private double cost;
    private int onlinePurchase;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

}

