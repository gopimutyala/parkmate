package com.mouritech.parkmate.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class ClientImage {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "client_image_id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID clientImageId;
    private String imageName;

    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

}

