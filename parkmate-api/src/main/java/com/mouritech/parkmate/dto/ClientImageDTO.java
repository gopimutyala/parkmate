package com.mouritech.parkmate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientImageDTO {

    private String clientImageId;
    private String imageName;
    private ClientDTO client;

}

