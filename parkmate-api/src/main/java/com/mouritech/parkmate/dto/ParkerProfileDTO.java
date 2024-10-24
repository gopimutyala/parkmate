package com.mouritech.parkmate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkerProfileDTO {

    private String parkerProfileId;
    private String firstName;
    private String lastName;
    private int active;
    private String contactEmail;
    private String contactPhone;
    private ClientDTO client;
    private OrganizationDTO organization;

}

