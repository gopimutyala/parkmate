package com.mouritech.parkmate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientBrandingDTO {

    private String clientBrandingId;
    private String value;
    private ClientDTO client;

}

