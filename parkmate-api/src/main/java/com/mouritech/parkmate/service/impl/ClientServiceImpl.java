package com.mouritech.parkmate.service.impl;

import com.mouritech.parkmate.dto.ClientDTO;
import com.mouritech.parkmate.entity.Client;
import com.mouritech.parkmate.entity.ClientBranding;
import com.mouritech.parkmate.entity.ClientImage;
import com.mouritech.parkmate.exception.ResourceNotFoundException;
import com.mouritech.parkmate.mapper.ClientBrandingMapper;
import com.mouritech.parkmate.mapper.ClientImageMapper;
import com.mouritech.parkmate.mapper.ClientMapper;
import com.mouritech.parkmate.repository.ClientRepository;
import com.mouritech.parkmate.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    ClientBrandingMapper clientBrandingMapper;

    @Autowired
    ClientImageMapper clientImageMapper;

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();

        return clients
                .stream()
                .map(client -> clientMapper.convertToDTO(client))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClient(UUID id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client ID not found: "+id));

        return clientMapper.convertToDTO(client);
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = clientMapper.convertToEntity(clientDTO);

        populateChild(clientDTO, client);

        client = clientRepository.save(client);

        clientDTO = clientMapper.convertToDTO(client);

        return clientDTO;
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {

        Client client = clientRepository.findById(UUID.fromString(clientDTO.getClientId()))
                .orElseThrow(() -> new ResourceNotFoundException("Client ID not found: "+clientDTO.getClientId()));

        populateChild(clientDTO, client);

        clientRepository.save(clientMapper.convertToEntity(clientDTO));

        return clientDTO;
    }

    @Override
    public void deleteClient(UUID id) {
        clientRepository.deleteById(id);
    }

    private void populateChild(ClientDTO clientDTO, Client client) {
        if(clientDTO.getClientBrandings() != null) {
            List<ClientBranding> clientBrandings = clientDTO.getClientBrandings()
                    .stream()
                    .map(clientBrandingDTO -> clientBrandingMapper.convertToEntity(clientBrandingDTO))
                    .collect(Collectors.toList());

            for(ClientBranding clientBranding : clientBrandings) {
                clientBranding.setClient(client);
            }
            client.setClientBrandings(clientBrandings);
        }

        if(clientDTO.getClientImages() != null) {
            List<ClientImage> clientImages = clientDTO.getClientImages()
                    .stream()
                    .map(clientImage -> clientImageMapper.convertToEntity(clientImage))
                    .collect(Collectors.toList());

            for(ClientImage clientImage : clientImages) {
                clientImage.setClient(client);
            }
            client.setClientImages(clientImages);
        }
    }


}

