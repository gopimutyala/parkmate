package com.mouritech.parkmate.service.impl;

import com.mouritech.parkmate.dto.ClientBrandingDTO;
import com.mouritech.parkmate.entity.ClientBranding;
import com.mouritech.parkmate.exception.ResourceNotFoundException;
import com.mouritech.parkmate.mapper.ClientBrandingMapper;
import com.mouritech.parkmate.repository.ClientBrandingRepository;
import com.mouritech.parkmate.service.ClientBrandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientBrandingServiceImpl implements ClientBrandingService {

    @Autowired
    private ClientBrandingRepository clientBrandingRepository;

    @Autowired
    ClientBrandingMapper clientBrandingMapper;

    @Override
    public List<ClientBrandingDTO> getAllClientBrandings() {
        List<ClientBranding> clientBrandings = clientBrandingRepository.findAll();

        return clientBrandings
                .stream()
                .map(clientBranding -> ClientBrandingMapper.getDTOFromEntity(clientBranding))
                .collect(Collectors.toList());
    }

    @Override
    public ClientBrandingDTO getClientBranding(UUID id) {
        ClientBranding clientBranding = clientBrandingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ClientBranding ID not found: "+id));

        return ClientBrandingMapper.getDTOFromEntity(clientBranding);
    }

    @Override
    public ClientBrandingDTO createClientBranding(ClientBrandingDTO clientBrandingDTO) {
        ClientBranding clientBranding = clientBrandingMapper.convertToEntity(clientBrandingDTO);

        clientBranding = clientBrandingRepository.save(clientBranding);

        clientBrandingDTO = clientBrandingMapper.convertToDTO(clientBranding);

        return clientBrandingDTO;
    }

    @Override
    public ClientBrandingDTO updateClientBranding(ClientBrandingDTO clientBrandingDTO) {
        clientBrandingRepository.findById(UUID.fromString(clientBrandingDTO.getClientBrandingId()))
                .orElseThrow(() -> new ResourceNotFoundException("ClientBranding ID not found: "+clientBrandingDTO.getClientBrandingId()));

        clientBrandingRepository.save(clientBrandingMapper.convertToEntity(clientBrandingDTO));

        return clientBrandingDTO;
    }

    @Override
    public void deleteClientBranding(UUID id) {
        clientBrandingRepository.deleteById(id);
    }

    @Override
    public List<ClientBrandingDTO> getClientBrandingByClientId(UUID id) {
        List<ClientBranding> clientBrandings = clientBrandingRepository.findByClientClientId(id);

        return clientBrandings
                .stream()
                .map(clientBranding -> ClientBrandingMapper.getDTOFromEntity(clientBranding))
                .collect(Collectors.toList());
    }
}

