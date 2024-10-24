package com.mouritech.parkmate.service.impl;

import com.mouritech.parkmate.dto.ParkerProfileDTO;
import com.mouritech.parkmate.entity.ParkerProfile;
import com.mouritech.parkmate.exception.ResourceNotFoundException;
import com.mouritech.parkmate.mapper.ParkerProfileMapper;
import com.mouritech.parkmate.repository.ParkerProfileRepository;
import com.mouritech.parkmate.service.ParkerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkerProfileServiceImpl implements ParkerProfileService {

    @Autowired
    private ParkerProfileRepository parkerProfileRepository;

    @Autowired
    ParkerProfileMapper parkerProfileMapper;

    @Override
    public List<ParkerProfileDTO> getAllParkerProfiles() {
        List<ParkerProfile> parkerProfiles = parkerProfileRepository.findAll();

        return parkerProfiles
                .stream()
                .map(parkerProfile -> ParkerProfileMapper.getDTOFromEntity(parkerProfile))
                .collect(Collectors.toList());
    }

    @Override
    public ParkerProfileDTO getParkerProfile(UUID id) {
        ParkerProfile parkerProfile = parkerProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ParkerProfile ID not found: "+id));

        return ParkerProfileMapper.getDTOFromEntity(parkerProfile);
    }

    @Override
    public ParkerProfileDTO createParkerProfile(ParkerProfileDTO parkerProfileDTO) {
        ParkerProfile parkerProfile = parkerProfileMapper.convertToEntity(parkerProfileDTO);

        parkerProfile = parkerProfileRepository.save(parkerProfile);

        parkerProfileDTO = parkerProfileMapper.convertToDTO(parkerProfile);

        return parkerProfileDTO;
    }

    @Override
    public ParkerProfileDTO updateParkerProfile(ParkerProfileDTO parkerProfileDTO) {
        parkerProfileRepository.findById(UUID.fromString(parkerProfileDTO.getParkerProfileId()))
                .orElseThrow(() -> new ResourceNotFoundException("ParkerProfile ID not found: "+parkerProfileDTO.getParkerProfileId()));

        parkerProfileRepository.save(parkerProfileMapper.convertToEntity(parkerProfileDTO));

        return parkerProfileDTO;
    }

    @Override
    public void deleteParkerProfile(UUID id) {
        parkerProfileRepository.deleteById(id);
    }

    @Override
    public List<ParkerProfileDTO> getParkerProfileByClientId(UUID id) {
        List<ParkerProfile> parkerProfiles = parkerProfileRepository.findByClientClientId(id);

        return parkerProfiles
                .stream()
                .map(parkerProfile -> ParkerProfileMapper.getDTOFromEntity(parkerProfile))
                .collect(Collectors.toList());
    }

    @Override
    public List<ParkerProfileDTO> getParkerProfileByOrganizationId(UUID id) {
        List<ParkerProfile> parkerProfiles = parkerProfileRepository.findByOrganizationOrganizationId(id);

        return parkerProfiles
                .stream()
                .map(parkerProfile -> ParkerProfileMapper.getDTOFromEntity(parkerProfile))
                .collect(Collectors.toList());
    }

}

