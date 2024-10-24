package com.mouritech.parkmate.mapper;

import com.mouritech.parkmate.dto.ClientDTO;
import com.mouritech.parkmate.dto.ClientImageDTO;
import com.mouritech.parkmate.entity.Client;
import com.mouritech.parkmate.entity.ClientImage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientImageMapper {

    @Autowired
    ModelMapper parkmateModelMapper;

    public ClientImage convertToEntity(ClientImageDTO clientImageDTO) {
        return parkmateModelMapper.map(clientImageDTO, ClientImage.class);
    }

    public ClientImageDTO convertToDTO(ClientImage clientImage) {
        return parkmateModelMapper.map(clientImage, ClientImageDTO.class);
    }

    public static ClientImageDTO getDTOFromEntity(ClientImage clientImage) {
        ClientImageDTO clientImageDTO = new ClientImageDTO();
        clientImageDTO.setClientImageId(clientImage.getClientImageId().toString());
        clientImageDTO.setImageName(clientImage.getImageName());

        ClientDTO clientDTO = new ClientDTO();
        Client client = clientImage.getClient();
        clientDTO.setClientId(clientImage.getClient().getClientId().toString());
        clientDTO.setActive(client.getActive());
        clientDTO.setVersion(client.getVersion());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setPortalurl(client.getPortalurl());
        clientImageDTO.setClient(clientDTO);

        return clientImageDTO;
    }
}
