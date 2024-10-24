package com.mouritech.parkmate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String productId;
    private int active;
    private BillingFrequency billingFrequency;
    private double cost;
    private int onlinePurchase;
    private ClientDTO client;

}

