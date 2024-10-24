package com.mouritech.parkmate.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private String clientId;
    private int active;
    private String portalurl;
    private int version;
    private String phone;

    private List<ClientBrandingDTO> clientBrandings;
    private List<ClientImageDTO> clientImages;
    private List<OrganizationDTO> organizations;
    private List<ParkerProfileDTO> parkerProfiles;

}

