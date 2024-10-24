package com.mouritech.parkmate.service;


import com.mouritech.parkmate.dto.ParkerProfileDTO;

import java.util.List;
import java.util.UUID;

public interface ParkerProfileService {

    List<ParkerProfileDTO> getAllParkerProfiles();

    ParkerProfileDTO getParkerProfile(UUID id);

    ParkerProfileDTO createParkerProfile(ParkerProfileDTO parkerProfileDTO);

    ParkerProfileDTO updateParkerProfile(ParkerProfileDTO parkerProfileDTO);

    void deleteParkerProfile(UUID id);

    List<ParkerProfileDTO> getParkerProfileByClientId(UUID id);

    List<ParkerProfileDTO> getParkerProfileByOrganizationId(UUID id);
}

