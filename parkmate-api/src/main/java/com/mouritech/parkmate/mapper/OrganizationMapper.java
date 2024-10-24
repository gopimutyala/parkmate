package com.mouritech.parkmate.mapper;

import com.mouritech.parkmate.dto.ClientDTO;
import com.mouritech.parkmate.dto.OrganizationDTO;
import com.mouritech.parkmate.entity.Client;
import com.mouritech.parkmate.entity.Organization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMapper {

    @Autowired
    ModelMapper parkmateModelMapper;

    public Organization convertToEntity(OrganizationDTO organizationDTO) {
        return parkmateModelMapper.map(organizationDTO, Organization.class);
    }

    public OrganizationDTO convertToDTO(Organization organization) {
        return parkmateModelMapper.map(organization, OrganizationDTO.class);
    }

    public static OrganizationDTO getDTOFromEntity(Organization organization) {
        OrganizationDTO organizationDTO = new OrganizationDTO();
        organizationDTO.setOrganizationId(organization.getOrganizationId().toString());
        organizationDTO.setActive(organization.getActive());
        organizationDTO.setVersion(organization.getVersion());
        organizationDTO.setParkerProfileApprovalRequired(organization.getParkerProfileApprovalRequired());

        ClientDTO clientDTO = new ClientDTO();
        Client client = organization.getClient();
        clientDTO.setClientId(organization.getClient().getClientId().toString());
        clientDTO.setActive(client.getActive());
        clientDTO.setVersion(client.getVersion());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setPortalurl(client.getPortalurl());
        organizationDTO.setClient(clientDTO);

        return organizationDTO;
    }
}
