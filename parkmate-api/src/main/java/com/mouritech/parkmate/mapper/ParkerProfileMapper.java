package com.mouritech.parkmate.mapper;

import com.mouritech.parkmate.dto.ClientDTO;
import com.mouritech.parkmate.dto.OrganizationDTO;
import com.mouritech.parkmate.dto.ParkerProfileDTO;
import com.mouritech.parkmate.entity.Client;
import com.mouritech.parkmate.entity.Organization;
import com.mouritech.parkmate.entity.ParkerProfile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkerProfileMapper {

    @Autowired
    ModelMapper parkmateModelMapper;

    public ParkerProfile convertToEntity(ParkerProfileDTO parkerProfileDTO) {
        return parkmateModelMapper.map(parkerProfileDTO, ParkerProfile.class);
    }

    public ParkerProfileDTO convertToDTO(ParkerProfile parkerProfile) {
        return parkmateModelMapper.map(parkerProfile, ParkerProfileDTO.class);
    }

    public static ParkerProfileDTO getDTOFromEntity(ParkerProfile parkerProfile) {
        ParkerProfileDTO parkerProfileDTO = new ParkerProfileDTO();
        parkerProfileDTO.setParkerProfileId(parkerProfile.getParkerProfileId().toString());
        parkerProfileDTO.setContactEmail(parkerProfile.getContactEmail());
        parkerProfileDTO.setContactPhone(parkerProfile.getContactPhone());
        parkerProfileDTO.setFirstName(parkerProfile.getFirstName());
        parkerProfileDTO.setLastName(parkerProfile.getLastName());
        parkerProfileDTO.setActive(parkerProfile.getActive());

        ClientDTO clientDTO = new ClientDTO();
        Client client = parkerProfile.getClient();
        clientDTO.setClientId(parkerProfile.getClient().getClientId().toString());
        clientDTO.setActive(client.getActive());
        clientDTO.setVersion(client.getVersion());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setPortalurl(client.getPortalurl());
        parkerProfileDTO.setClient(clientDTO);

        OrganizationDTO organizationDTO = new OrganizationDTO();
        Organization organization = parkerProfile.getOrganization();
        organizationDTO.setOrganizationId(organization.getOrganizationId().toString());
        organizationDTO.setActive(organization.getActive());
        organizationDTO.setVersion(organization.getVersion());
        organizationDTO.setParkerProfileApprovalRequired(organization.getParkerProfileApprovalRequired());
        parkerProfileDTO.setOrganization(organizationDTO);

        return parkerProfileDTO;
    }
}
