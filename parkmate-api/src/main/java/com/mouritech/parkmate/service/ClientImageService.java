package com.mouritech.parkmate.service;


import com.mouritech.parkmate.dto.ClientImageDTO;

import java.util.List;
import java.util.UUID;

public interface ClientImageService {

    List<ClientImageDTO> getAllClientImages();

    ClientImageDTO getClientImage(UUID id);

    ClientImageDTO createClientImage(ClientImageDTO clientImageDTO);

    ClientImageDTO updateClientImage(ClientImageDTO clientImageDTO);

    void deleteClientImage(UUID id);

    List<ClientImageDTO> getClientImageByClientId(UUID id);
}

