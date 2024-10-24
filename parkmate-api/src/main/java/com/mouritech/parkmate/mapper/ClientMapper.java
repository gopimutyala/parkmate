package com.mouritech.parkmate.mapper;

import com.mouritech.parkmate.dto.ClientBrandingDTO;
import com.mouritech.parkmate.dto.ClientDTO;
import com.mouritech.parkmate.dto.ClientImageDTO;
import com.mouritech.parkmate.entity.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    @Autowired
    ModelMapper parkmateModelMapper;

    public Client convertToEntity(ClientDTO clientDTO) {
        return parkmateModelMapper.map(clientDTO, Client.class);
    }

    public ClientDTO convertToDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientId(client.getClientId().toString());
        clientDTO.setActive(client.getActive());
        clientDTO.setVersion(client.getVersion());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setPortalurl(client.getPortalurl());

        if(client.getClientBrandings() != null) {
            List<ClientBrandingDTO> clientBrandingDTOs = client.getClientBrandings().stream()
                    .map(ClientBrandingMapper::getDTOFromEntity)
                    .collect(Collectors.toList());
            clientDTO.setClientBrandings(clientBrandingDTOs);
        }

        if(client.getClientImages() != null) {
            List<ClientImageDTO> clientImageDTOs = client.getClientImages().stream()
                    .map(ClientImageMapper::getDTOFromEntity)
                    .collect(Collectors.toList());
            clientDTO.setClientImages(clientImageDTOs);
        }

        return clientDTO;
    }
}
