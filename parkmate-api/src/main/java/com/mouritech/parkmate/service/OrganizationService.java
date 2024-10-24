package com.mouritech.parkmate.service;


import com.mouritech.parkmate.dto.OrganizationDTO;

import java.util.List;
import java.util.UUID;

public interface OrganizationService {

    List<OrganizationDTO> getAllOrganizations();

    OrganizationDTO getOrganization(UUID id);

    OrganizationDTO createOrganization(OrganizationDTO organizationDTO);

    OrganizationDTO updateOrganization(OrganizationDTO organizationDTO);

    void deleteOrganization(UUID id);

    List<OrganizationDTO> getOrganizationByClientId(UUID id);
}

