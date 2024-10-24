package com.mouritech.parkmate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO {

    private String organizationId;
    private int active;
    private int version;
    private int parkerProfileApprovalRequired;
    private ClientDTO client;

    private List<ParkerProfileDTO> parkerProfiles;
}

