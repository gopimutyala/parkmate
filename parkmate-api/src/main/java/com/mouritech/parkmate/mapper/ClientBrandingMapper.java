package com.mouritech.parkmate.mapper;

import com.mouritech.parkmate.dto.ClientBrandingDTO;
import com.mouritech.parkmate.dto.ClientDTO;
import com.mouritech.parkmate.entity.Client;
import com.mouritech.parkmate.entity.ClientBranding;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientBrandingMapper {

    @Autowired
    ModelMapper parkmateModelMapper;

    public ClientBranding convertToEntity(ClientBrandingDTO clientBrandingDTO) {

        return parkmateModelMapper.map(clientBrandingDTO, ClientBranding.class);
    }

    public ClientBrandingDTO convertToDTO(ClientBranding clientBranding) {
        return parkmateModelMapper.map(clientBranding, ClientBrandingDTO.class);
    }

    public static ClientBrandingDTO getDTOFromEntity(ClientBranding clientBranding) {
        ClientBrandingDTO clientBrandingDTO = new ClientBrandingDTO();
        clientBrandingDTO.setClientBrandingId(clientBranding.getClientBrandingId().toString());
        clientBrandingDTO.setValue(clientBranding.getValue());

        ClientDTO clientDTO = new ClientDTO();
        Client client = clientBranding.getClient();
        clientDTO.setClientId(clientBranding.getClient().getClientId().toString());
        clientDTO.setActive(client.getActive());
        clientDTO.setVersion(client.getVersion());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setPortalurl(client.getPortalurl());
        clientBrandingDTO.setClient(clientDTO);

        return clientBrandingDTO;
    }
}
