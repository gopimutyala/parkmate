package com.mouritech.parkmate.service;


import com.mouritech.parkmate.dto.ClientDTO;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    List<ClientDTO> getAllClients();

    ClientDTO getClient(UUID id);

    ClientDTO createClient(ClientDTO clientDTO);

    void deleteClient(UUID id);

    ClientDTO updateClient(ClientDTO clientDTO);
}

