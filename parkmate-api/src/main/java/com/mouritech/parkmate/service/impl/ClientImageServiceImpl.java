package com.mouritech.parkmate.service.impl;

import com.mouritech.parkmate.dto.ClientImageDTO;
import com.mouritech.parkmate.entity.ClientImage;
import com.mouritech.parkmate.exception.ResourceNotFoundException;
import com.mouritech.parkmate.mapper.ClientImageMapper;
import com.mouritech.parkmate.repository.ClientImageRepository;
import com.mouritech.parkmate.service.ClientImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientImageServiceImpl implements ClientImageService {

    @Autowired
    private ClientImageRepository clientImageRepository;

    @Autowired
    ClientImageMapper clientImageMapper;

    @Override
    public List<ClientImageDTO> getAllClientImages() {
        List<ClientImage> clientImages = clientImageRepository.findAll();

        return clientImages
                .stream()
                .map(clientImage -> ClientImageMapper.getDTOFromEntity(clientImage))
                .collect(Collectors.toList());
    }

    @Override
    public ClientImageDTO getClientImage(UUID id) {
        ClientImage clientImage = clientImageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ClientImage ID not found: "+id));

        return ClientImageMapper.getDTOFromEntity(clientImage);
    }

    @Override
    public ClientImageDTO createClientImage(ClientImageDTO clientImageDTO) {
        ClientImage clientImage = clientImageMapper.convertToEntity(clientImageDTO);

        clientImage = clientImageRepository.save(clientImage);

        clientImageDTO = clientImageMapper.convertToDTO(clientImage);

        return clientImageDTO;
    }

    @Override
    public ClientImageDTO updateClientImage(ClientImageDTO clientImageDTO) {
        clientImageRepository.findById(UUID.fromString(clientImageDTO.getClientImageId()))
                .orElseThrow(() -> new ResourceNotFoundException("ClientImage ID not found: "+clientImageDTO.getClientImageId()));

        clientImageRepository.save(clientImageMapper.convertToEntity(clientImageDTO));

        return clientImageDTO;
    }

    @Override
    public void deleteClientImage(UUID id) {
        clientImageRepository.deleteById(id);
    }

    @Override
    public List<ClientImageDTO> getClientImageByClientId(UUID id) {
        List<ClientImage> clientImages = clientImageRepository.findByClientClientId(id);

        return clientImages
                .stream()
                .map(clientImage -> ClientImageMapper.getDTOFromEntity(clientImage))
                .collect(Collectors.toList());
    }
}

