package com.mouritech.parkmate.service;


import com.mouritech.parkmate.dto.ClientBrandingDTO;
import com.mouritech.parkmate.dto.ClientDTO;

import java.util.List;
import java.util.UUID;

public interface ClientBrandingService {

    List<ClientBrandingDTO> getAllClientBrandings();

    ClientBrandingDTO getClientBranding(UUID id);

    ClientBrandingDTO createClientBranding(ClientBrandingDTO clientBrandingDTO);

    ClientBrandingDTO updateClientBranding(ClientBrandingDTO clientBrandingDTO);

    void deleteClientBranding(UUID id);

    List<ClientBrandingDTO> getClientBrandingByClientId(UUID id);
}

